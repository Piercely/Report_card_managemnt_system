package top;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.*;
import java.util.Scanner;

class Select_avg extends Test_J {

	public static void select_avg() throws ClassNotFoundException, SQLException, FileNotFoundException {

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
			System.out.println("����������û���:");
			String username = reader.next();
			System.out.println("��������Ŀγ̺�:");
			String Cno = reader.next();
			System.out.println("���������:");
			String C_date = reader.next();
			Statement sql1 = con.createStatement();// Statement�ӿ�
			ResultSet re1 = sql1.executeQuery("SELECT username,course.Cno,AVG(C_score) FROM grade,course WHERE C_date='"
					+ C_date + "' AND course.`username`='" + username + "' AND course.Cno='" + Cno
					+ "' AND course.`Cno`=grade.`Cno` AND course.`Cname`=grade.`Cname` group by username,course.Cno");// executeQuery��ѯ----ResultSet�����
			// 4.���ղ���������
			System.out.println("    ��ѯ��.....");
			if (re1.next()) {
				// ����һ����ӡ������������Ŀ����E���µ�Select_avg.txt�ļ�
				PrintStream out = System.out;
				// ����ϵͳĬ�ϵĴ�ӡ���������
				PrintStream ps = new PrintStream("E:\\Select_avg.txt");
				System.setOut(ps);
				// �Ѵ����Ĵ�ӡ���������ϵͳ����ϵͳ�´��� ps���
				String username1 = re1.getString("username");
				System.out.println("�û���: " + username1);
				String Cno1 = re1.getString("course.Cno");
				System.out.println("�γ̺�: " + Cno1);
				String avg = re1.getString("avg(C_score)");
				System.out.println("��ƽ����: " + avg);

				ps.close();
				System.setOut(out);// �Ѵ�ӡ���������ϵͳ
				String username11 = re1.getString("username");
				System.out.println("�û���: " + username11);
				String Cno11 = re1.getString("course.Cno");
				System.out.println("�γ̺�: " + Cno11);
				String avg1 = re1.getString("avg(C_score)");
				System.out.println("��ƽ����: " + avg1);
				System.out.print("----��ѯ����!\n");
			} else {
				System.out.print("δ��ѯ�������Ϣ,������˶�!\n");
			}

			re1.close();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
