package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String username="root";
	private static final String password="root";
	private static final String url="jdbc:mysql://localhost:3306/registration";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		try {
			Scanner scr=new Scanner(System.in);
			Class.forName(Driver);
			conn =DriverManager.getConnection(url, username, password);
			System.out.println("Enter email");
			String email=scr.next();
			System.out.println("Enter password");
			String password=scr.next();
			String sql="select * from regestrationdetails where email=? and regestrationdetailscol=?";
			pmst=conn.prepareStatement(sql);
			pmst.setString(1, email);
			pmst.setString(2, password);
			ResultSet rs=pmst.executeQuery();
			if(rs.next()) {
				System.out.println("Successfully logined");
			}
			else {
				System.out.println("Invalid user");
			}
			conn.close();
			pmst.close();
			scr.close();
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
