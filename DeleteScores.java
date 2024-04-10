package top;

import java.util.*;
import java.sql.*;

class DeleteScores extends Test_J {

	public static void Deletescores() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "dai324542");
			Statement sql = con.createStatement();

			Scanner reader = new Scanner(System.in);
			System.out.println("-----删除界面-----");
			System.out.println("—— 1- 成绩表 \t—— 2-课程表\n");
			System.out.println("请选择你要删除的表( 1 or 2 ): ");
			int type = reader.nextInt();
			if (type == 1) {
				System.out.println("请输入课程号:");
				String Cno = reader.next();
				System.out.println("请输入课程名:");
				String Cname = reader.next();
				System.out.println("请输入考试记录:");
				String C_record = reader.next();
				int n = sql.executeUpdate("delete from grade  where  Cno='" + Cno + "'and Cname='" + Cname
						+ "' and C_record='" + C_record + "'");
				if (n > 0) {
					System.out.println("删除成功!");
				} else {
					System.out.println("未查询到相应数据,删除失败!");
				}
			} else if (type == 2) {
				System.out.println("请输入用户名:");
				String username1 = reader.next();
				System.out.println("请输入课程号:");
				String Cno = reader.next();
				int n = sql
						.executeUpdate("delete from course  where  username='" + username1 + "' and Cno='" + Cno + "'");
				if (n > 0) {
					System.out.println("删除成功!");
				} else {
					System.out.println("未查询到相应数据,删除失败!");
				}
			} else {
				System.out.println("请按要求选择你要删除的表!");
			}

			// 5.断开连接，关闭数据库
			con.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}
}