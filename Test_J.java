package top;

import com.mysql.jdbc.Driver;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Test_J {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
		System.out.println("----------��ӭʹ�ø��˳ɼ���Ϣ����ϵͳ----------");
		System.out.println("��ѡ����Ҫ���еĲ���( 1 or 2 ): \n ���� 1- ע��.\t ���� 2- ��¼.");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();

		if (num == 1) {
			while (true) {

				Scanner reader = new Scanner(System.in);
				System.out.println("------ע��ҳ��------");
				System.out.println("�������û���:");
				String username = reader.next();
				System.out.println("����������:");
				String password = reader.next();
				System.out.println("��ȷ������:");
				String password1 = reader.next();
				if (password.equals(password1)) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root",
								"dai324542");
						Statement sql = con.createStatement();
						ResultSet s = sql.executeQuery("select * from users where username='" + username + "'");
						if (s.next()) {
							System.out.println("�Բ����û����Ѵ���!");
						} else {
							int n = sql.executeUpdate("insert into users(username,password) value('" + username + "','"
									+ password + "')");
							if (n > 0) {
								System.out.println("......ע����");
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("\nע��ɹ�!");
								System.out.println("\n���˳�,�����µ�¼!");
								break;

							} else {
								System.out.println("ע��ʧ��,������!");
								con.close();
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ע��ʧ��,�����������벻һ��!");
				}
			}
		}
		if (num == 2) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				int number = 0;
				while (true) {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root",
							"dai324542");
					Statement sql = con.createStatement();
					System.out.println("-----��½ҳ��-----");

					System.out.println("�������û���: ");
					Scanner reader = new Scanner(System.in);
					String username = reader.next();
					System.out.println("����������: ");
					String password = reader.next();
					ResultSet rs = sql.executeQuery(
							"select * from users where username='" + username + "' and password='" + password + "'");

					if (rs.next()) {
						System.out.println("......��½��\n");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("��½�ɹ�!\n");
						break;
					} else {
						number = number + 1;
						System.out.println("��½ʧ��,�û������������,������˶�!\n");
//						System.out.println("" + number);
						if (number == 3) {
							System.out.println("��½ʧ�ܴ����������,�����˳�!\n");
							System.exit(0);
							break;
						}
					}
					/*
					 * �����˳� statusΪ0ʱΪ�����˳�����Ҳ���ǽ�����ǰ���������е�java�������
					 * 
					 * �������˳� statusΪ��0����������������������һ����1����-1������ʾ�������˳���ǰ����
					 */
					// 5.�Ͽ����ӣ��ر����ݿ�
					rs.close();
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}

			while (true)

			{
				System.out.println("----------��ӭʹ�ø��˳ɼ���Ϣ����ϵͳ----------");

				System.out.println("���� 1-��ӿγ�.\t\t5-��ѯ��Ϣ.\t   ����");
				System.out.println("���� 2-��ӳɼ�.\t\t6-�޸���Ϣ.\t   ����");
				System.out.println("���� 3-��ѯ��ƽ���ɼ�.\t7-ɾ����Ϣ. \t   ����");
				System.out.println("���� 4-��ѯ����ɼ�����.\t8-�޸�����.\t   ����");
				System.out.println("���� 9-�˳�����\t\t\t\t   ����");
				System.out.println("---------------------------------------------");
				System.out.println("\n���������ָ��( 1 ~ 9 ): ______");
				Scanner scanner = new Scanner(System.in);
				String cmd = scanner.nextLine();
				switch (cmd) {
				case "1":
					AddCourse.Addcourse();
					break;
				case "2":
					AddScores.Addscores();
					break;
				case "3":
					Select_avg.select_avg();
					break;
				case "4":
					SelectDesc.Selectdesc();
					break;
				case "5":
					SelectUser.Selectuser();
					break;
				case "6":
					UpdateScores.Updatescores();
					break;
				case "7":
					DeleteScores.Deletescores();
					break;
				case "8":
					Updatepassword.updatepassword();
					break;
				case "9":
					System.out.println("��лʹ��!Byebye~");
					System.exit(0);

					Connection connection = null;
					Statement statement = null;
					ResultSet set = null;
					try {
						// 1.�������ݿ�����
						Class.forName("com.mysql.jdbc.Driver");
						// 2.ͨ��DriverManager��ȡ���ݿ�����
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root",
								"dai324542");
						Statement sql = con.createStatement();
					} catch (ClassNotFoundException e) {
						System.out.println("---������ʾ:���ݿ���������ʧ��");
						e.printStackTrace();
					} catch (SQLException e) {
						System.out.println("---������ʾ:���ݿ����ʧ��");
						e.printStackTrace();
					} finally {
						if (set != null) {
							try {
								set.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						if (statement != null) {
							try {
								statement.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}

				}
			}
		}
	}
}
