package com.shivam.ToDo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/delete_ToDo")
public class Delete_ToDo_Servlet extends HttpServlet {

    ToDoService service=new ToDoService();
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String detail = httpServletRequest.getParameter("todo");
        System.out.println(detail);
        service.removeToDo(detail);
        httpServletResponse.sendRedirect("/list_todo");


    }
}
