package top;

import java.sql.*;
import java.util.Scanner;

class AddScores extends Test_J {

	public static void Addscores() throws ClassNotFoundException, SQLException {
		Scanner reader = new Scanner(System.in);
		System.out.println("------��ӳɼ�ҳ��------");
		System.out.println("������γ̺�:");
		String Cno = reader.next();
		System.out.println("������γ���:");
		String Cname = reader.next();
		System.out.println("�����뿼�Լ�¼:");
		String C_record = reader.next();
		System.out.println("�����뿼�Է���:");
		String C_score = reader.next();
		System.out.println("�����뿼�����:");
		String C_date = reader.next();
		if (1 > 0) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "dai324542");
				Statement sql = con.createStatement();
				ResultSet s = sql.executeQuery("select * from grade where grade.Cno='" + Cno + "'and grade.Cname='"
						+ Cname + "'and grade.C_record='" + C_record + "'and grade.C_score='" + C_score
						+ "'and grade.C_date='" + C_date + "'");
				if (s.next()) {
					System.out.println("�Բ���,�ɼ���Ϣ�Ѵ���!");
				} else {
					int n = sql.executeUpdate("insert into grade(Cno,Cname,C_record,C_score,C_date) value('" + Cno
							+ "','" + Cname + "','" + C_record + "','" + C_score + "','" + C_date + "')");
					if (n > 0) {
						System.out.println("�ɼ���Ϣ��ӳɹ�!");
					} else {
						System.out.println("�ɼ���Ϣ���ʧ��");
						con.close();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
