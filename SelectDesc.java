package top;

import java.sql.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;

class SelectDesc extends Test_J {

	public static void Selectdesc() throws ClassNotFoundException, SQLException {
		// 1.����JDBC��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.�������ݿ������
		try {
			System.out.println("�������ݿ�...");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "dai324542");
			// 3.ִ��SQL���

			Scanner reader3 = new Scanner(System.in);
			System.out.println("------��ѯҳ��------");

			Scanner reader = new Scanner(System.in);

			System.out.println("������γ̺�:");
			String Cno = reader.next();
			System.out.println("������γ���:");
			String Cname = reader.next();
			System.out.println("���������:");
			String C_date = reader.next();
			Statement sql1 = con.createStatement();// Statement�ӿ�
			ResultSet re1 = sql1.executeQuery("SELECT * FROM grade WHERE `Cno`='" + Cno + "' AND `Cname`='" + Cname
					+ "' AND C_date='" + C_date + "' ORDER BY C_score DESC");// executeQuery��ѯ----ResultSet�����
			// 4.���ղ���������
			System.out.println("    ��ѯ��.....");
			while (re1.next()) {

				String Cno1 = re1.getString("Cno");
				System.out.print("\t�γ̺�: " + Cno1);
				String Cname1 = re1.getString("Cname");
				System.out.print("\t�γ���: " + Cname1);
				String C_record = re1.getString("C_record");
				System.out.print("\t���Լ�¼: " + C_record);
				String C_score = re1.getString("C_score");
				System.out.print("\t���Է���: " + C_score);
				String C_date1 = re1.getString("C_date");
				System.out.println("\t�������: " + C_date1);
			}

			System.out.print("----��ѯ����!\n");
			re1.close();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
