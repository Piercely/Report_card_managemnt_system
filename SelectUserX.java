package top;

import java.sql.*;
import java.util.Scanner;

class SelectUser extends Test_J {

	public static void Selectuser() throws ClassNotFoundException, SQLException {
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
			System.out.println("��ѡ����Ҫ���еĲ���( 1 or 2 ): \n���� 1-��ѯ�γ̱�.  \t���� 2-��ѯ�ɼ���.\n");
			int n = reader3.nextInt();
			if (n == 1) {

				Scanner reader = new Scanner(System.in);
				System.out.println("-----��ѯ�γ̼�¼ҳ��-----");
				System.out.println("�����������û���:");
				String username1 = reader.next();

				Statement sql = con.createStatement();// Statement�ӿ�
				ResultSet re = sql.executeQuery("select * from course where username='" + username1 + "'");// executeQuery��ѯ----ResultSet�����
				// 4.���ղ���������
				System.out.println("    ��ѯ��.....");
				if (re.next() == false) {
					System.out.print("δ��ѯ�������Ϣ,������˶�!\n");
				} else {
					String username = re.getString("username");
					String Cno = re.getString("Cno");
					String Cname = re.getString("Cname");
					// �������
					System.out.println("�û���: " + username);
					System.out.println("�γ̺�: " + Cno);
					System.out.println("�γ���: " + Cname);
					System.out.print("----��ѯ����!\n");
					while (re.next() == true) {
						String username11 = re.getString("username");
						String Cno1 = re.getString("Cno");
						String Cname1 = re.getString("Cname");
						// �������
						System.out.println("�û���: " + username11);
						System.out.println("�γ̺�: " + Cno1);
						System.out.println("�γ���: " + Cname1);
						System.out.print("----��ѯ����!\n");

					}
				}

				re.close();
			} else if (n == 2) {
				System.out.println("------��ѯ�ɼ���¼ҳ��------");
				System.out.println("�����������û���:");
				Scanner reader2 = new Scanner(System.in);
				String username1 = reader2.next();
				System.out.println("���������Ŀγ̺�:");
				Scanner reader4 = new Scanner(System.in);
				String Cno1 = reader2.next();

				Statement sql2 = con.createStatement();// Statement�ӿ�
				ResultSet re2 = sql2.executeQuery(
						"SELECT * FROM grade,course WHERE grade.`Cno`='" + Cno1 + "' AND course.username='" + username1
								+ "'AND grade.`Cno`=course.`Cno`AND grade.Cname=course.`Cname`");// executeQuery��ѯ----ResultSet�����
				// 4.���ղ���������
				System.out.println("    ��ѯ��.....");
				if (re2.next() == false) {
					System.out.print("δ��ѯ�������Ϣ,������˶�!\n");
				} else {
					String Cno = re2.getString("Cno");
					String Cname = re2.getString("Cname");
					String C_record = re2.getString("C_record");
					String C_score = re2.getString("C_score");
					String C_date = re2.getString("C_date");
					// �������
					System.out.println("�γ̺�: " + Cno);
					System.out.println("�γ���: " + Cname);
					System.out.println("���Լ�¼: " + C_record);
					System.out.println("���Գɼ�: " + C_score);
					System.out.println("����ʱ��: " + C_date);
					System.out.print("----��ѯ����!\n");
					while (re2.next()) {
						String Cno11 = re2.getString("Cno");
						String Cname1 = re2.getString("Cname");
						String C_record1 = re2.getString("C_record");
						String C_score1 = re2.getString("C_score");
						String C_date1 = re2.getString("C_date");
						// �������
						System.out.println("�γ̺�: " + Cno11);
						System.out.println("�γ���: " + Cname1);
						System.out.println("���Լ�¼: " + C_record1);
						System.out.println("���Գɼ�: " + C_score1);
						System.out.println("����ʱ��: " + C_date1);
						System.out.print("----��ѯ����!\n");
					}
				}
				re2.close();
			}

			// 5.�Ͽ����ӣ��ر����ݿ�
			else {
				System.out.print("�밴Ҫ�����ѡ���ѯҳ�棡");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
