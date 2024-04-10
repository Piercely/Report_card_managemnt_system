package top;

import java.sql.*;
import java.util.Scanner;

class UpdateScores extends Test_J {

	public static void Updatescores() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "dai324542");
			Statement sql = con.createStatement();
			Scanner reader = new Scanner(System.in);
			System.out.println("输入你要修改的表( 1 or 2 ): \n—— 1- 成绩表 \t —— 2- 课程表");
			int type = reader.nextInt();
			if (type == 1) {
				System.out.println("请输入你的课程号:");
				String Cno = reader.next();
				System.out.println("请输入你的考试记录:");
				String C_record = reader.next();
				System.out.println("请输入你修改后的分数:");
				String new_score = reader.next();
				int a = sql.executeUpdate("update grade set C_score='" + new_score + "' where Cno='" + Cno
						+ "' and C_record='" + C_record + "'");
				if (a > 0) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败!\\n---输入信息有误,请认真核对!");
				}
			} else if (type == 2) {
				System.out.println("请输入你的用户名:");
				String username = reader.next();
				System.out.println("请输入你的课程号:");
				String Cno = reader.next();
				System.out.println("请输入你修改后的课程名:");
				String Cname = reader.next();
				int b = sql.executeUpdate("update course set Cname='" + Cname + "' where username='" + username
						+ "'and Cno='" + Cno + "'");
				if (b > 0) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败!\n---输入信息有误,请认真核对!");
				}
			} else {
				System.out.println("输入选项有误,请按要求进行选择!");
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}