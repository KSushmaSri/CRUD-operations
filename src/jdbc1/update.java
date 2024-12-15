package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {
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
			System.out.println("Enter table name");
			String sql="update "+scr.next()+" set id=?,name=?,email=?,regestrationdetailscol=? where id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("Enter id");
			pmst.setInt(1, scr.nextInt());
			System.out.println("Enter name");
			pmst.setString(2, scr.next());
			System.out.println("Enter email");
			pmst.setString(3, scr.next());
			System.out.println("Enter password");
			pmst.setString(4, scr.next());
			System.out.println("provide id");
			pmst.setInt(5, scr.nextInt());
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("Updated Successfully");
			}
			else {
				System.out.println("Error");
			}
			conn.close();
			pmst.close();
			scr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
