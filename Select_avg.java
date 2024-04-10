package top;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.*;
import java.util.Scanner;

class Select_avg extends Test_J {

	public static void select_avg() throws ClassNotFoundException, SQLException, FileNotFoundException {

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
			System.out.println("请输入你的用户名:");
			String username = reader.next();
			System.out.println("请输入你的课程号:");
			String Cno = reader.next();
			System.out.println("请输入年份:");
			String C_date = reader.next();
			Statement sql1 = con.createStatement();// Statement接口
			ResultSet re1 = sql1.executeQuery("SELECT username,course.Cno,AVG(C_score) FROM grade,course WHERE C_date='"
					+ C_date + "' AND course.`username`='" + username + "' AND course.Cno='" + Cno
					+ "' AND course.`Cno`=grade.`Cno` AND course.`Cname`=grade.`Cname` group by username,course.Cno");// executeQuery查询----ResultSet结果集
			// 4.接收并处理结果集
			System.out.println("    查询中.....");
			if (re1.next()) {
				// 创建一个打印输出流，输出的目标是E盘下的Select_avg.txt文件
				PrintStream out = System.out;
				// 保存系统默认的打印输出流缓存
				PrintStream ps = new PrintStream("E:\\Select_avg.txt");
				System.setOut(ps);
				// 把创建的打印输出流赋给系统。即系统下次向 ps输出
				String username1 = re1.getString("username");
				System.out.println("用户名: " + username1);
				String Cno1 = re1.getString("course.Cno");
				System.out.println("课程号: " + Cno1);
				String avg = re1.getString("avg(C_score)");
				System.out.println("年平均分: " + avg);

				ps.close();
				System.setOut(out);// 把打印输出流还给系统
				String username11 = re1.getString("username");
				System.out.println("用户名: " + username11);
				String Cno11 = re1.getString("course.Cno");
				System.out.println("课程号: " + Cno11);
				String avg1 = re1.getString("avg(C_score)");
				System.out.println("年平均分: " + avg1);
				System.out.print("----查询结束!\n");
			} else {
				System.out.print("未查询到相关信息,请认真核对!\n");
			}

			re1.close();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
