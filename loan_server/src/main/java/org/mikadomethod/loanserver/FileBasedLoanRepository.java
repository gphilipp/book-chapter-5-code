package org.mikadomethod.loanserver;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

public class FileBasedLoanRepository implements LoanRepository {

    public final static String FILE_EXTENSION = ".loan";
    public final static String REPOSITORY_ROOT = System.getProperty("user.home") + "/loan";

    @Override
	public LoanApplication fetch(String ticketId) {
        return fetch(Long.parseLong(ticketId));
    }

    public LoanApplication fetch(long ticketId) {
        File file = fileFromApplication(ticketId);
        try {
            String output = new Scanner(file).useDelimiter("\\Z").next();
            return new Gson().fromJson(output, LoanApplication.class);
        } catch (FileNotFoundException e) {
            throw new ApplicationException("Ticket not found", e);
        }
    }

    @Override
	public Ticket store(LoanApplication application) {
        try {
        	application.setApplicationNo(getNextId());
            new File(REPOSITORY_ROOT).mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(
                    fileFromApplication(application.getApplicationNo()));
            fileOutputStream.write(new Gson().toJson(application).getBytes());
            fileOutputStream.close();
            return new Ticket(application.getApplicationNo());
        } catch (FileNotFoundException e) {
            throw new ApplicationException("Could not store application", e);
        } catch (IOException e) {
            throw new ApplicationException("Could not store application", e);
        }
    }

    private static File fileFromApplication(long applicationNo) {
        return new File(REPOSITORY_ROOT + "/" + applicationNo + FILE_EXTENSION);
    }

    @Override
	public Ticket approve(String ticketId) {
        LoanApplication application = fetch(ticketId);
        application.approve();
        store(application);
        return new Ticket(application.getApplicationNo());
    }

	private static long getNextId() {
	    File file = new File(REPOSITORY_ROOT);
	    File[] files = file.listFiles(new FileFilter() {
	        @Override
	        public boolean accept(File pathname) {
	            return pathname.getName().endsWith(FILE_EXTENSION);
	        }
	    });
	
	    return files == null ? 0 : files.length + 1;
	}

}
