package com.resultset.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnResultSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //load or register the driver.
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Define the connection properties,url,username,password
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "786786";

        //Establish the connection  between java program and database

        Connection con = DriverManager.getConnection(url, user, password);

        //Retrieve the records from dept table
        String quString = "select * from  dept";

        //creating statement Object
        Statement stmtObj = con.createStatement();

        // ResultSet rs=stmtObj.executeQuery(quString);
        ResultSet resultSet = stmtObj.executeQuery(quString);

        System.out.println("Department Details are :");

        while (resultSet.next()) {
            System.out.println("DEptno is : " + resultSet.getDouble(1));
            System.out.println("DeptName is : " + resultSet.getString(2));
            System.out.println("Loc is : " + resultSet.getString("loc"));
            System.out.println("+++++=======+++++");
        }

        resultSet.close();
        stmtObj.close();
        con.close();
    }
}