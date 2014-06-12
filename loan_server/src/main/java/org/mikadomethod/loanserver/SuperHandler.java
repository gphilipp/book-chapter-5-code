package org.mikadomethod.loanserver;

import com.google.gson.Gson;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Gilles Philippart
 */
public abstract class SuperHandler extends AbstractHandler {

    public static final String APPROVE = "approve";

    public abstract void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException;

    protected boolean isApproval(HttpServletRequest request) {
        return APPROVE.equals(request.getParameter("action"));
    }

    protected String approveLoan(String parameter) {
        return new Gson().toJson(LoanRepository.approve(parameter));
    }
}
