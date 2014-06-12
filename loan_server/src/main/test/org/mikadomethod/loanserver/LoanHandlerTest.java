package org.mikadomethod.loanserver;

import junit.framework.Assert;
import org.eclipse.jetty.io.UncheckedPrintWriter;
import org.eclipse.jetty.server.Request;
import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

import static org.junit.Assert.*;

public class LoanHandlerTest {

    @Test
    public void should_not_answer_to_approval() throws Exception {
        LoanHandler lh = new LoanHandler();
        StringWriter out = new StringWriter();
        lh.handleAction(new MyHttpServletRequest(), new UncheckedPrintWriter(out));
        Assert.assertEquals(LoanHandler.INCORRECT_PARAMETERS_PROVIDED, out.toString().trim());
    }

    private static class MyHttpServletRequest implements HttpServletRequest {
        @Override
        public String getAuthType() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Cookie[] getCookies() {
            throw new UnsupportedOperationException();
        }

        @Override
        public long getDateHeader(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getHeader(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Enumeration<String> getHeaders(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getIntHeader(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getMethod() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getPathInfo() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getPathTranslated() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getContextPath() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getQueryString() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getRemoteUser() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isUserInRole(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Principal getUserPrincipal() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getRequestedSessionId() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getRequestURI() {
            throw new UnsupportedOperationException();
        }

        @Override
        public StringBuffer getRequestURL() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getServletPath() {
            throw new UnsupportedOperationException();
        }

        @Override
        public HttpSession getSession(boolean b) {
            throw new UnsupportedOperationException();
        }

        @Override
        public HttpSession getSession() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isRequestedSessionIdValid() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isRequestedSessionIdFromCookie() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isRequestedSessionIdFromURL() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isRequestedSessionIdFromUrl() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void login(String s, String s2) throws ServletException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void logout() throws ServletException {
            throw new UnsupportedOperationException();
        }

        @Override
        public Collection<Part> getParts() throws IOException, ServletException {
            throw new UnsupportedOperationException();
        }

        @Override
        public Part getPart(String s) throws IOException, ServletException {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object getAttribute(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getCharacterEncoding() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setCharacterEncoding(String s) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getContentLength() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getContentType() {
            throw new UnsupportedOperationException();
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getParameter(String s) {
            Map m = new HashMap();
            m.put("action", "approve");
            m.put("ticketId", "0");
            return (String) m.get(s);
        }

        @Override
        public Enumeration<String> getParameterNames() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String[] getParameterValues(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getProtocol() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getScheme() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getServerName() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getServerPort() {
            throw new UnsupportedOperationException();
        }

        @Override
        public BufferedReader getReader() throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getRemoteAddr() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getRemoteHost() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setAttribute(String s, Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void removeAttribute(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Locale getLocale() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Enumeration<Locale> getLocales() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isSecure() {
            throw new UnsupportedOperationException();
        }

        @Override
        public RequestDispatcher getRequestDispatcher(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getRealPath(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getRemotePort() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getLocalName() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getLocalAddr() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getLocalPort() {
            throw new UnsupportedOperationException();
        }

        @Override
        public ServletContext getServletContext() {
            throw new UnsupportedOperationException();
        }

        @Override
        public AsyncContext startAsync() throws IllegalStateException {
            throw new UnsupportedOperationException();
        }

        @Override
        public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isAsyncStarted() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isAsyncSupported() {
            throw new UnsupportedOperationException();
        }

        @Override
        public AsyncContext getAsyncContext() {
            throw new UnsupportedOperationException();
        }

        @Override
        public DispatcherType getDispatcherType() {
            throw new UnsupportedOperationException();
        }
    }
}