package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fmspj
 */
public class dbconnection {
    public static void main(String[] args){
        Connection dbConn = null;
        String strUrl = "jdbc:sqlite:src/main/db/testdb.db";
        System.out.println("-------------");
        try{
            
            Class.forName("org.sqlite.JDBC");
            dbConn = DriverManager.getConnection(strUrl,"pj","pj");            
            System.out.println("Connection made");
            Statement st = dbConn.createStatement();
            st.executeUpdate("INSERT INTO tasks(taskID, taskName, taskTime) " + "VALUES (1, 'Google Search', 12)");
            st.executeUpdate("INSERT INTO tasks(taskID, taskName, taskTime) " + "VALUES (2, 'Entering Data', 1)");
           
            System.out.println("preparing to run select * statement");
            PreparedStatement stmt = dbConn.prepareStatement("Select * From tasks");
            ResultSet rs = stmt.executeQuery();
            System.out.println("Data Info");
            while (rs.next()) {
                System.out.println("ID:");

                System.out.println(rs.getString(1));
                
                 System.out.println("Task Name:");

                System.out.println(rs.getString(2));
                
                System.out.println("Time");

                System.out.println(rs.getString(3));
                
            
                System.out.println();
                System.out.println("------Next Task-----");
               }
            
            
        }catch(Exception e){
                    
                    }
}
}
