package top;

import java.sql.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;

class SelectDesc extends Test_J {

	public static void Selectdesc() throws ClassNotFoundException, SQLException {
		// 1.加载JDBC驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.创建数据库的链接
		try {
			System.out.println("连接数据库...");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "dai324542");
			// 3.执行SQL语句

			Scanner reader3 = new Scanner(System.in);
			System.out.println("------查询页面------");

			Scanner reader = new Scanner(System.in);

			System.out.println("请输入课程号:");
			String Cno = reader.next();
			System.out.println("请输入课程名:");
			String Cname = reader.next();
			System.out.println("请输入年份:");
			String C_date = reader.next();
			Statement sql1 = con.createStatement();// Statement接口
			ResultSet re1 = sql1.executeQuery("SELECT * FROM grade WHERE `Cno`='" + Cno + "' AND `Cname`='" + Cname
					+ "' AND C_date='" + C_date + "' ORDER BY C_score DESC");// executeQuery查询----ResultSet结果集
			// 4.接收并处理结果集
			System.out.println("    查询中.....");
			while (re1.next()) {

				String Cno1 = re1.getString("Cno");
				System.out.print("\t课程号: " + Cno1);
				String Cname1 = re1.getString("Cname");
				System.out.print("\t课程名: " + Cname1);
				String C_record = re1.getString("C_record");
				System.out.print("\t考试记录: " + C_record);
				String C_score = re1.getString("C_score");
				System.out.print("\t考试分数: " + C_score);
				String C_date1 = re1.getString("C_date");
				System.out.println("\t考试年份: " + C_date1);
			}

			System.out.print("----查询结束!\n");
			re1.close();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
