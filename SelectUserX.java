package top;

import java.sql.*;
import java.util.Scanner;

class SelectUser extends Test_J {

	public static void Selectuser() throws ClassNotFoundException, SQLException {
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
			System.out.println("请选择你要进行的操作( 1 or 2 ): \n—— 1-查询课程表.  \t—— 2-查询成绩表.\n");
			int n = reader3.nextInt();
			if (n == 1) {

				Scanner reader = new Scanner(System.in);
				System.out.println("-----查询课程记录页面-----");
				System.out.println("请输入您的用户名:");
				String username1 = reader.next();

				Statement sql = con.createStatement();// Statement接口
				ResultSet re = sql.executeQuery("select * from course where username='" + username1 + "'");// executeQuery查询----ResultSet结果集
				// 4.接收并处理结果集
				System.out.println("    查询中.....");
				if (re.next() == false) {
					System.out.print("未查询到相关信息,请认真核对!\n");
				} else {
					String username = re.getString("username");
					String Cno = re.getString("Cno");
					String Cname = re.getString("Cname");
					// 输出数据
					System.out.println("用户名: " + username);
					System.out.println("课程号: " + Cno);
					System.out.println("课程名: " + Cname);
					System.out.print("----查询结束!\n");
					while (re.next() == true) {
						String username11 = re.getString("username");
						String Cno1 = re.getString("Cno");
						String Cname1 = re.getString("Cname");
						// 输出数据
						System.out.println("用户名: " + username11);
						System.out.println("课程号: " + Cno1);
						System.out.println("课程名: " + Cname1);
						System.out.print("----查询结束!\n");

					}
				}

				re.close();
			} else if (n == 2) {
				System.out.println("------查询成绩记录页面------");
				System.out.println("请输入您的用户名:");
				Scanner reader2 = new Scanner(System.in);
				String username1 = reader2.next();
				System.out.println("请输入您的课程号:");
				Scanner reader4 = new Scanner(System.in);
				String Cno1 = reader2.next();

				Statement sql2 = con.createStatement();// Statement接口
				ResultSet re2 = sql2.executeQuery(
						"SELECT * FROM grade,course WHERE grade.`Cno`='" + Cno1 + "' AND course.username='" + username1
								+ "'AND grade.`Cno`=course.`Cno`AND grade.Cname=course.`Cname`");// executeQuery查询----ResultSet结果集
				// 4.接收并处理结果集
				System.out.println("    查询中.....");
				if (re2.next() == false) {
					System.out.print("未查询到相关信息,请认真核对!\n");
				} else {
					String Cno = re2.getString("Cno");
					String Cname = re2.getString("Cname");
					String C_record = re2.getString("C_record");
					String C_score = re2.getString("C_score");
					String C_date = re2.getString("C_date");
					// 输出数据
					System.out.println("课程号: " + Cno);
					System.out.println("课程名: " + Cname);
					System.out.println("考试记录: " + C_record);
					System.out.println("考试成绩: " + C_score);
					System.out.println("考试时间: " + C_date);
					System.out.print("----查询结束!\n");
					while (re2.next()) {
						String Cno11 = re2.getString("Cno");
						String Cname1 = re2.getString("Cname");
						String C_record1 = re2.getString("C_record");
						String C_score1 = re2.getString("C_score");
						String C_date1 = re2.getString("C_date");
						// 输出数据
						System.out.println("课程号: " + Cno11);
						System.out.println("课程名: " + Cname1);
						System.out.println("考试记录: " + C_record1);
						System.out.println("考试成绩: " + C_score1);
						System.out.println("考试时间: " + C_date1);
						System.out.print("----查询结束!\n");
					}
				}
				re2.close();
			}

			// 5.断开连接，关闭数据库
			else {
				System.out.print("请按要求进行选择查询页面！");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
