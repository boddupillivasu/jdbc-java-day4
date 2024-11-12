package com.resultset.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ResultSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter dept no:");
        int no = scanner.nextInt();

        System.out.println("enter dept name:");
        String name =scanner.next();

        System.out.println("enter dept loc");
        String loc = scanner.next();

        //reg driver class

        Class.forName("com.mysql.cj.jdbc.Driver");

        //define connection

        String url= "jdbc:mysql://localhost:3306/jdbc";
        String user ="root";
        String password ="786786";

        Connection connection = DriverManager.getConnection(url,user,password);

        //create prepared statement obj

        String data ="insert into dept values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(data);



        preparedStatement.setInt(1,no);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,loc);

        int res = preparedStatement.executeUpdate();

        if(res>0){
            System.out.println("quires are updated");
        }else
            System.out.println("not updated");

        preparedStatement.close();
        connection.close();
        scanner.close();
    }
}
