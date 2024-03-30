package com.StudentPortal.AdminOperation;

import com.StudentPortal.PortalUtility.StudentPortal_Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operation {
    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static Connection connection;
    public static Statement statement;

    static {
        try {
            connection = StudentPortal_Utility.MyConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void studentInfo() throws SQLException, IOException {


        String sql = "Select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        boolean flag = false;
        System.out.println("RollNo\tName\tCourse");
        System.out.println("-------------------------");
        while (resultSet.next()) {
            flag = true;
            System.out.println(resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3) + "\t\t");

        }

        if (flag == false) {
            System.out.println("No Record Found");


        }
        connection.close();
    }

    public static void userList() throws SQLException {
        String sql = "Select * from users";
        ResultSet resultSet = statement.executeQuery(sql);
        boolean flag = false;
        System.out.println("UserName\tPassword");
        System.out.println("--------------------");
        while (resultSet.next()) {
            flag = true;
            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t");
        }
        if (flag == false) {
            System.out.println("No User Found");
        }
    }

    public static void deleteUser() throws IOException, SQLException {
        System.out.println("Enter UserName You Want To Delete");
        String uname = bf.readLine();
        String sql1 = "Select * from users where userName='" + uname + "'";
        ResultSet resultSet = statement.executeQuery(sql1);
        if (resultSet.next() == false) {
            System.out.println("USERNAME Not Found");
        } else {
            String sql = "DELETE FROM users where userName='" + uname + "'";

            statement.executeUpdate(sql);
            System.out.println("Deleted Successfully");
        }


    }

    public static void deleteStudent() throws IOException, SQLException {
        System.out.println("1 : Delete By RollNo");
        System.out.println("2 : Delete By Name");
        int a = Integer.parseInt(bf.readLine());
        if (a == 1) {
            System.out.println("Enter Roll No. :");
            int roll = Integer.parseInt(bf.readLine());
            String sql1 = "Select * from student where RollNo=" + roll;
            ResultSet resultSet = statement.executeQuery(sql1);
            if (resultSet.next() == false) {
                System.out.println("RollNo Not Found");
            } else {
                String sql = "DELETE FROM student where RollNo=" + roll;
                statement.executeUpdate(sql);
                System.out.println("Deleted Successfully");
            }

        } else if (a == 2) {
            System.out.println("Enter Name :");
            String name = bf.readLine();
            String sql1 = "Select * from student where Name='" + name + "'";
            ResultSet resultSet = statement.executeQuery(sql1);
            if (resultSet.next() == false) {
                System.out.println("Student Not Found");
            } else {
                String sql = "DELETE FROM student where Name='" + name + "'";

                statement.executeUpdate(sql);
                System.out.println("Deleted Successfully");

            }

        }


    }

    public static void searchStudent() throws IOException, SQLException {
        System.out.println("1 : SEARCH By Name");
        System.out.println("2 : SEARCH By RollNo");
        int ch = Integer.parseInt(bf.readLine());
        if (ch == 1) {
            System.out.println("Enter Name :");
            String name = bf.readLine();
            String sql = "Select * from student where Name='" + name + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            boolean flag = false;
            System.out.println("RollNo\t\tName\t\tCourse");
            System.out.println("-------------------------");
            while (resultSet.next()) {
                flag = true;
                System.out.println(resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3) + "\t\t");

            }

            if (flag == false) {
                System.out.println("No Record Found");


            }
        } else if (ch == 2) {
            System.out.println("Enter RollNo");
            int sroll = Integer.parseInt(bf.readLine());

            String sql = "Select * from student where RollNo=" + sroll;
            ResultSet resultSet = statement.executeQuery(sql);
            boolean flag = false;
            System.out.println("RollNo\t\tName\t\tCourse");
            System.out.println("-------------------------");
            while (resultSet.next()) {
                flag = true;
                System.out.println(resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3) + "\t\t");

            }

            if (flag == false) {
                System.out.println("No Record Found");


            }

        }
    }
}

