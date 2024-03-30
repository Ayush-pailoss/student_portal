package com.StudentPortal.Login;

import com.StudentPortal.PortalUtility.StudentPortal_Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class PortalLogin {
        public static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

    public static void portalLogin() throws IOException, SQLException {

        System.out.println("Enter UserName : ");
        String uname=bf.readLine();
       Connection connection=StudentPortal_Utility.MyConnection();
        Statement statement=connection.createStatement();
        String sql1="Select * from users where userName='"+uname+"'";
        ResultSet resultSet=statement.executeQuery(sql1);
        if (resultSet.next()==false)
        {
            System.out.println("USERNAME Not Found");
        }
        else {
            System.out.println("Enter Password : ");
            String pass = bf.readLine();

            String sql2="SELECT * from users where userName='"+uname+"'"+" and"+" password='"+pass+"'";

            ResultSet resultSet1=statement.executeQuery(sql2);
            if (resultSet1.next())
            {
                System.out.println("LOGIN SUCCESSFUL:::::");
                System.out.println("Enter Your Roll Number :");
                int roll= Integer.parseInt(bf.readLine());
                String sql="Select * from student where RollNo="+roll;
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                ResultSet rs=preparedStatement.executeQuery();
                while (rs.next())
                {
                    int RollNo=rs.getInt(1);
                    String Name=rs.getString(2);
                    String Course=rs.getString(3);
                    System.out.println("WELCOME::::::::: "+ Name);

                }



            }
            else
            {
                System.out.println("Wrong Username or Password");

            }

        }
    }
}
