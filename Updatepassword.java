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

			System.out.println("-----�޸�����ҳ��-----");
			System.out.println("�������û���:");
			String name = reader.next();
			System.out.println("�����������:");
			String oldpwd = reader.next();
			ResultSet re = sql
					.executeQuery("select * from users where username='" + name + "' and password='" + oldpwd + "'");
			if (re.next()) {
				System.out.println("������������:");
				String newpwd1 = reader.next();
				System.out.println("��ȷ��������:");
				String newpwd2 = reader.next();
				if (newpwd1.equals(newpwd2)) {
					int n = sql
							.executeUpdate("update users set password='" + newpwd1 + "'where username='" + name + "'");
					if (n > 0) {
						System.out.println("�����޸ĳɹ�!");
					} else {
						System.out.println("�����޸�ʧ��!");
					}
				} else {
					System.out.println("�޸�ʧ�ܣ��������������������벻һ��!");
				}
			} else {
				System.out.println("�Բ����������������û�������!");
			}

			// 5.�Ͽ����ӣ��ر����ݿ�
			re.close();
			con.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}
}