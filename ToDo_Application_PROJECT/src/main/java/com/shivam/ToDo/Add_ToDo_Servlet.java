package com.shivam.ToDo;

import com.shivam.login.UserValidationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/add_todo")
public class Add_ToDo_Servlet extends HttpServlet {

    ToDoService service=new ToDoService();


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.getRequestDispatcher("/WEB-INF/views/new_todo.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ToDoService add_todo_services=new ToDoService();

        String detail=request.getParameter("newToDO");
        String category=request.getParameter("category");
        String date=request.getParameter("date");


        add_todo_services.addNewTodo(new UserValidationService().getUID(),detail,category,date);
        response.sendRedirect("/list_todo");


    }
}
