package top;

import java.sql.*;
import java.util.Scanner;

class AddCourse extends Test_J {

	public static void Addcourse() throws ClassNotFoundException, SQLException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("------��ӿγ�ҳ��------");
		System.out.println("�������û���:");
		String username = reader.next();
		System.out.println("������γ̺�:");
		String Cno = reader.next();
		System.out.println("������γ���:");
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
					System.out.println("���ʧ��,�γ��Ѵ���!");
				} else {
					int n = sql.executeUpdate("insert into course(username,Cno,Cname) value('" + username + "','" + Cno
							+ "','" + Cname + "')");
					if (n > 0) {
						System.out.println("�γ���ӳɹ�");
					} else {
						System.out.println("�γ����ʧ��");
						con.close();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
