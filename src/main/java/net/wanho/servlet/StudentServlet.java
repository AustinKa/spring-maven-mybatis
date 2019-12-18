package net.wanho.servlet;

import net.wanho.pjo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */
@WebServlet("/stus")
public class StudentServlet extends HttpServlet {
    private StudentServiceI studentServiceI;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Student> stus = studentServiceI.getAllStus();
        request.setAttribute("stus", stus);
        request.getRequestDispatcher("/student.jsp").forward(request,response);
    }

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
         studentServiceI = ctx.getBean(StudentServiceI.class);
    }
}
