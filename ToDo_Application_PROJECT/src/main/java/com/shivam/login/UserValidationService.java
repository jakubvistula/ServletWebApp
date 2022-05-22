package com.shivam.login;

import com.shivam.connect_database.Connect_to_DB;

import java.sql.*;
public class UserValidationService {
    private Statement statement;
    private ResultSet result;
    private static int uid=-1;

    public boolean isValid(String name,String pass){

        try {
            statement= Connect_to_DB.connectDB();

            result=statement.executeQuery("Select uname,upass,uid from user_reg where uname='"+name.toLowerCase()+"'and upass = '"+pass+"'");

            if (result.next() && result.getString("upass").equals(pass)){
                this.uid=result.getInt("uid");
                return true;
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                Connect_to_DB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    public int getUID(){
        return this.uid;
    }






}
