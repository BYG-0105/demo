package com.nwnu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {

    public TestServlet() {
        System.out.println("This is constructor lodaing");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("This is my first demo");
        ServletContext ctxt =this.getServletContext();
           Integer count = (Integer) ctxt.getAttribute("count");
           if(count == null)
           {
               count = 0;
           }
           count++;
           ctxt.setAttribute("count",count);
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + count + "</h1>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
