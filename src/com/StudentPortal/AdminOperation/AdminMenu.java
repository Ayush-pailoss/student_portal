package com.StudentPortal.AdminOperation;

import com.StudentPortal.ControllerMenu.StudentPortal_Menu;
import com.StudentPortal.Registration.StudentReistration;
import com.StudentPortal.Registration.UserRegistration;

import java.io.IOException;
import java.sql.SQLException;

import static com.StudentPortal.ControllerMenu.StudentPortal_Menu.bf;

public class AdminMenu {

    public static void adminMenu() throws SQLException, IOException {
        while (true) {

            System.out.println("Press 1 to Show List Of Users");
            System.out.println("Press 2 to Show List Of Student");
            System.out.println("Press 3 to Add A User");
            System.out.println("Press 4 to Add A Student");
            System.out.println("Press 5 To Delete A User ");
            System.out.println("Press 6 to Delete A Student");
            System.out.println("Press 7 To Update A User ");
            System.out.println("Press 8 To Update A Student");
            System.out.println("Press 9 To Search A Student");
            System.out.println("Press 0 To Log Out");
            int c = Integer.parseInt(bf.readLine());
            if (c == 1) {
                Operation.userList();
            } else if (c==2) {
                Operation.studentInfo();

            } else if (c==3) {
                UserRegistration.userRegistration();

            } else if (c==4) {
                StudentReistration.registration();

            } else if (c==5) {
                Operation.deleteUser();
            } else if (c==6) {
                Operation.deleteStudent();
            } else if (c==9) {
                Operation.searchStudent();

            } else if (c==0) {
                System.out.println("Logged Out Successfully");
                StudentPortal_Menu.Menu();
                break;
            }


        }
    }
}

