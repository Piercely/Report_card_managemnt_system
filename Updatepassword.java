package top;

import java.util.*;
import java.sql.*;

class Updatepassword extends Test_J {

	public static void updatepassword() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "dai324542");
			Statement sql = con.createStatement();

			Scanner reader = new Scanner(System.in);

			System.out.println("-----修改密码页面-----");
			System.out.println("请输入用户名:");
			String name = reader.next();
			System.out.println("请输入旧密码:");
			String oldpwd = reader.next();
			ResultSet re = sql
					.executeQuery("select * from users where username='" + name + "' and password='" + oldpwd + "'");
			if (re.next()) {
				System.out.println("请输入新密码:");
				String newpwd1 = reader.next();
				System.out.println("请确认新密码:");
				String newpwd2 = reader.next();
				if (newpwd1.equals(newpwd2)) {
					int n = sql
							.executeUpdate("update users set password='" + newpwd1 + "'where username='" + name + "'");
					if (n > 0) {
						System.out.println("密码修改成功!");
					} else {
						System.out.println("密码修改失败!");
					}
				} else {
					System.out.println("修改失败，你输入的新密码与旧密码不一致!");
				}
			} else {
				System.out.println("对不起，你输入的密码或用户名有误!");
			}

			// 5.断开连接，关闭数据库
			re.close();
			con.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}
}