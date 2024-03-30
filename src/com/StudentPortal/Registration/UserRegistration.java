package com.StudentPortal.Registration;

import com.StudentPortal.Credentials.Users;
import com.StudentPortal.PortalUtility.StudentPortal_Utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.StudentPortal.Registration.StudentReistration.bf;

public class UserRegistration {
    public static void userRegistration() throws SQLException, IOException {
    loop1:   while (true) {
           System.out.println("Enter Username");
           String uname = bf.readLine();
           String password;
      loop2:     while (true) {
               System.out.println("Enter Password");
               password = bf.readLine();
               System.out.println("Confirm Password :");
               String repass = bf.readLine();
               if (!password.equals(repass)) {
                   System.out.println("Password Do Not Match");
                   break loop2;
               }
               Users users = new Users(uname, password);

               Connection connection = StudentPortal_Utility.MyConnection();
               String sql2 = "INSERT INTO users values(?,?)";
               PreparedStatement pst1 = connection.prepareStatement(sql2);
               pst1.setString(1, users.getUsername());
               pst1.setString(2, users.getPassword());
               pst1.executeUpdate();
               System.out.println("Account Created Successfully");
          System.out.println("Press 1 to Register ");
          System.out.println("Press 2 To Exit");
          int ch=Integer.parseInt(bf.readLine());
          if (ch==1)
          {
              StudentReistration.registration();

          } else if (ch==2) {
              break loop1;
          }
          break loop1;

           }
       }
    }

}
