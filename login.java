import java.io.*;
import java.util.*;
import java.sql.*;
class login {
public static void main(String args[])  {
Connection con;
Statement st;
ResultSet rs;
Scanner scanner=new Scanner(System.in);
try {
     System.out.print("enter username:");
     String username=scanner.nextLine();
     System.out.print("enter password:");
     String password=scanner.nextLine();
     
     Class.forName("com.mysql.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db? characterEncoding=utf8", "root", ""); 
     st=con.createStatement();
     String str = "SELECT * FROM emp WHERE username = '" + username + "' AND password = '" + password + "'";
     rs=st.executeQuery(str);
     if(rs.next()) {
     System.out.println("Valid");
      } else {
     System.out.println("Not Valid");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

   
