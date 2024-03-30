package com.StudentPortal.Registration;

import com.StudentPortal.ControllerMenu.StudentPortal_Menu;
import com.StudentPortal.Credentials.Users;
import com.StudentPortal.Entity.Student;
import com.StudentPortal.PortalUtility.StudentPortal_Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentReistration {
    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void registration() throws IOException, SQLException {
        while (true) {

            System.out.println("Enter RollNo :");
            int rollno = Integer.parseInt(bf.readLine());
            System.out.println("Enter Name Of Student :");
            String name = bf.readLine();
            System.out.println("Enter Course :");
            String course = bf.readLine();
            Student student = new Student(rollno, name, course);

            System.out.println("Confirm Details:::::");
            System.out.println(student.getStudent_Name());
            System.out.println(student.getRollNo());
            System.out.println(student.getCourse());

            System.out.println("Press 1 to Confirm");
            System.out.println("Press 2 to Edit");
            int ch = Integer.parseInt(bf.readLine());
            if (ch == 1) {
                Connection connection = StudentPortal_Utility.MyConnection();
                Statement statement = connection.createStatement();
                String sql1 = "INSERT INTO student values (?,?,?)";
                PreparedStatement pst = connection.prepareStatement(sql1);

                pst.setInt(1, student.getRollNo());
                pst.setString(2, student.getStudent_Name());
                pst.setString(3, student.getCourse());
                pst.executeUpdate();


                System.out.println("Student Registered Successfully:::::::");
                StudentPortal_Menu.Menu();

                break;

            }
            else {
                registration();
                break;
            }

        }
    }
}
