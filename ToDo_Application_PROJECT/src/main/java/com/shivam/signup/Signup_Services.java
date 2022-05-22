package com.shivam.signup;

import com.shivam.connect_database.Connect_to_DB;

import java.sql.*;
public class Signup_Services {

    private Statement statement;
    private ResultSet result;

    public String addNewUser(String name,String password,String email){


        try {
            statement= Connect_to_DB.connectDB();

            result=statement.executeQuery("select uname from user_reg where uemail='"+email+"'");

            if (!result.next()){
                result=statement.executeQuery("select uname from user_reg ");
                while (result.next()){
                    if (result.getString("uname").equals(name.toLowerCase())){
                        System.out.println("USERNAME not AVAILABLE !");
                        return "USERNAME NOT AVAILABLE :( TRY AGAIN.";
                    }
                }

                statement.execute("Insert into user_reg(uname,upass,uemail) values('"+name+"','"+password+"','"+email+"')");
                return "Successfully Signed Up. Now LogIn again.";
            }

            System.out.println("Already registered !");
            return "User Already Registered !";
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                Connect_to_DB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Some error occur while adding user. Try after some time.";
    }
}
