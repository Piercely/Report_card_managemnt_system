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
			System.out.println("-----ɾ������-----");
			System.out.println("���� 1- �ɼ��� \t���� 2-�γ̱�\n");
			System.out.println("��ѡ����Ҫɾ���ı�( 1 or 2 ): ");
			int type = reader.nextInt();
			if (type == 1) {
				System.out.println("������γ̺�:");
				String Cno = reader.next();
				System.out.println("������γ���:");
				String Cname = reader.next();
				System.out.println("�����뿼�Լ�¼:");
				String C_record = reader.next();
				int n = sql.executeUpdate("delete from grade  where  Cno='" + Cno + "'and Cname='" + Cname
						+ "' and C_record='" + C_record + "'");
				if (n > 0) {
					System.out.println("ɾ���ɹ�!");
				} else {
					System.out.println("δ��ѯ����Ӧ����,ɾ��ʧ��!");
				}
			} else if (type == 2) {
				System.out.println("�������û���:");
				String username1 = reader.next();
				System.out.println("������γ̺�:");
				String Cno = reader.next();
				int n = sql
						.executeUpdate("delete from course  where  username='" + username1 + "' and Cno='" + Cno + "'");
				if (n > 0) {
					System.out.println("ɾ���ɹ�!");
				} else {
					System.out.println("δ��ѯ����Ӧ����,ɾ��ʧ��!");
				}
			} else {
				System.out.println("�밴Ҫ��ѡ����Ҫɾ���ı�!");
			}

			// 5.�Ͽ����ӣ��ر����ݿ�
			con.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}
}