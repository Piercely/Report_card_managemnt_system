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
			System.out.println("������Ҫ�޸ĵı�( 1 or 2 ): \n���� 1- �ɼ��� \t ���� 2- �γ̱�");
			int type = reader.nextInt();
			if (type == 1) {
				System.out.println("��������Ŀγ̺�:");
				String Cno = reader.next();
				System.out.println("��������Ŀ��Լ�¼:");
				String C_record = reader.next();
				System.out.println("���������޸ĺ�ķ���:");
				String new_score = reader.next();
				int a = sql.executeUpdate("update grade set C_score='" + new_score + "' where Cno='" + Cno
						+ "' and C_record='" + C_record + "'");
				if (a > 0) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println("�޸�ʧ��!\\n---������Ϣ����,������˶�!");
				}
			} else if (type == 2) {
				System.out.println("����������û���:");
				String username = reader.next();
				System.out.println("��������Ŀγ̺�:");
				String Cno = reader.next();
				System.out.println("���������޸ĺ�Ŀγ���:");
				String Cname = reader.next();
				int b = sql.executeUpdate("update course set Cname='" + Cname + "' where username='" + username
						+ "'and Cno='" + Cno + "'");
				if (b > 0) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println("�޸�ʧ��!\n---������Ϣ����,������˶�!");
				}
			} else {
				System.out.println("����ѡ������,�밴Ҫ�����ѡ��!");
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}