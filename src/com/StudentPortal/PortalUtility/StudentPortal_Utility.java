package com.StudentPortal.PortalUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentPortal_Utility {

    public static Connection MyConnection() throws SQLException {
          String url="jdbc:mysql://localhost:3306/student_portal?createDatabaseIfDoesNotExists=true";
        String usename="root";
        String pwd="admin";
            Connection connection= DriverManager.getConnection(url,usename,pwd);
      //  System.out.println("Connected");
            return connection;
    }
}
