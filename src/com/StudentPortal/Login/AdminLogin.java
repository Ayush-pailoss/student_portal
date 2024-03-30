package com.StudentPortal.Login;

import com.StudentPortal.AdminOperation.AdminMenu;
import com.StudentPortal.AdminOperation.Operation;
import com.StudentPortal.PortalUtility.StudentPortal_Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.StudentPortal.Login.PortalLogin.bf;

public class AdminLogin {
    static public BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static boolean falg = false;

    public static void adminLogin() {
        while (true) {


            System.out.println("Enter UserName : ");
            try {
                String UserName = bufferedReader.readLine();
                System.out.println("Enter Password");
                String pass = bufferedReader.readLine();

                Connection connection = StudentPortal_Utility.MyConnection();
                Statement statement = connection.createStatement();
                String query = "SELECT * from admin where userName='" + UserName + "'" + " and" + " password='" + pass + "'";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    falg = true;
                    System.out.println("Login Successful");
                    System.out.println("Welcome ::::::: " + resultSet.getString(1));
                    AdminMenu.adminMenu();


                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}