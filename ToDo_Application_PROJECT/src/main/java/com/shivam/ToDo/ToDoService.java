package com.shivam.ToDo;

import com.shivam.connect_database.Connect_to_DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoService {
    private Statement statement;
    private ResultSet result;

    public  boolean addNewTodo(int uid,String detail,String category,String date){


        try {
            statement= Connect_to_DB.connectDB();

            return statement.execute("INSERT into todos(tdetail,tcategory,tdate,uid) values ('"+detail+"','"+category+"','"+date
                    +"','"+uid+"')");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can't add todo !");
        }finally {
            try {
                Connect_to_DB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public List<ToDo_Data_Model> fetchTodos(int uid){


        try {

            statement=Connect_to_DB.connectDB();
            ArrayList<ToDo_Data_Model> list = new ArrayList<ToDo_Data_Model>();
            result = statement.executeQuery("SELECT tdetail,tcategory,tdate FROM todos where uid=" + uid);
            while (result.next()){
                String detail=result.getString("tdetail");
                String category=result.getString("tcategory");
                String date=result.getString("tdate");
                list.add(new ToDo_Data_Model(detail,category,date));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                Connect_to_DB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public boolean removeToDo(String detail){

        try {
            Statement statement= Connect_to_DB.connectDB();
            return statement.execute("DELETE  FROM todos where tdetail='"+detail+"'");
        }catch (SQLException e){
            System.out.println("Error while deleting :( "+e.getMessage());
        }
        return false;
    }


}
