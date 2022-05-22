package com.shivam.login;


import com.shivam.mailing.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Timer;

@WebServlet(urlPatterns = "/login")
public class Login_Servlet extends HttpServlet {


    public void init(){
        Timer timer=new Timer();
        timer.schedule(new Task(),0,10000);
    }


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String name=httpServletRequest.getParameter("name");
        String pass=httpServletRequest.getParameter("pw");
        String date=httpServletRequest.getParameter("date");

        UserValidationService user=new UserValidationService();



        if (user.isValid(name,pass)) {
            httpServletRequest.getSession().setAttribute("name",name);


            httpServletRequest.getSession().setAttribute("date",date);
            httpServletRequest.getSession().setAttribute("uid",user.getUID());
            httpServletResponse.sendRedirect("/list_todo");

        }else{

            httpServletRequest.setAttribute("Error", "Invalid Credentials ! Try again : (");

            httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }
}

