package top;

import java.sql.*;
import java.util.Scanner;

class AddCourse extends Test_J {

	public static void Addcourse() throws ClassNotFoundException, SQLException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("------添加课程页面------");
		System.out.println("请输入用户名:");
		String username = reader.next();
		System.out.println("请输入课程号:");
		String Cno = reader.next();
		System.out.println("请输入课程名:");
		String Cname = reader.next();
		if (1 > 0) /* true */ {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "dai324542");
				Statement sql = con.createStatement();
				ResultSet s = sql.executeQuery(
						"select * from course where username='" + username + "'and course.Cno='" + Cno + "'");
				if (s.next()) {
					System.out.println("添加失败,课程已存在!");
				} else {
					int n = sql.executeUpdate("insert into course(username,Cno,Cname) value('" + username + "','" + Cno
							+ "','" + Cname + "')");
					if (n > 0) {
						System.out.println("课程添加成功");
					} else {
						System.out.println("课程添加失败");
						con.close();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
