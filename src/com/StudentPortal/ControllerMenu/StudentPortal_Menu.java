package com.StudentPortal.ControllerMenu;

import com.StudentPortal.Login.AdminLogin;
import com.StudentPortal.Login.PortalLogin;
import com.StudentPortal.Registration.StudentReistration;
import com.StudentPortal.Registration.UserRegistration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class StudentPortal_Menu {
    public static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    public static void Menu() throws IOException, SQLException {
        while (true) {
            System.out.println("Press 1 to Login to Account");
            System.out.println("Don't have a Account ? Press 2 to Create Account");
            System.out.println("Press 3 to Login As ADMIN");
            System.out.println("Press 0 to Exit");
            int choice = Integer.parseInt(bf.readLine());
            if (choice == 1) {
                PortalLogin.portalLogin();
            } else if (choice == 2) {
                UserRegistration.userRegistration();


            } else if (choice == 3) {
                AdminLogin.adminLogin();
            }
            else if (choice==0)
            {
                System.out.println("THANK-YOU FOR VISITING !!!!");
                break;
            }

        }
    }
}
