package com.nwnu.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class demo extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World 2021!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ServletContext ctxt  =this.getServletContext();
        Integer count = (Integer) ctxt.getAttribute("count");
        if(count==null)
        {
            count = 0;
        }
        count++;
        ctxt.setAttribute("count",count);
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>" + count + "</h2>");
        out.println("</body></html>");
    }
}
