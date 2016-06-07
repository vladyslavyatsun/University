package ua.university.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by dog on 2/5/16.
 */
@WebServlet(name = "ua.university.servlet.Servlet", urlPatterns = {"/GenericServlet"})
public class GenericSer extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(11111111);
        PrintWriter pw = servletResponse.getWriter();
        Enumeration e = servletRequest.getParameterNames();

        while (e.hasMoreElements()){
            String pname = (String)e.nextElement();
            pw.print(pname + " = ");
            String pvalue = servletRequest.getParameter(pname);
            pw.println(pvalue);
        }
    }
}
