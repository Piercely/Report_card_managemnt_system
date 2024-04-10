package top;

import com.mysql.jdbc.Driver;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Test_J {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
		System.out.println("----------欢迎使用个人成绩信息管理系统----------");
		System.out.println("请选择你要进行的操作( 1 or 2 ): \n —— 1- 注册.\t —— 2- 登录.");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();

		if (num == 1) {
			while (true) {

				Scanner reader = new Scanner(System.in);
				System.out.println("------注册页面------");
				System.out.println("请输入用户名:");
				String username = reader.next();
				System.out.println("请输入密码:");
				String password = reader.next();
				System.out.println("请确认密码:");
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
							System.out.println("对不起，用户名已存在!");
						} else {
							int n = sql.executeUpdate("insert into users(username,password) value('" + username + "','"
									+ password + "')");
							if (n > 0) {
								System.out.println("......注册中");
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("\n注册成功!");
								System.out.println("\n已退出,请重新登录!");
								break;

							} else {
								System.out.println("注册失败,请重试!");
								con.close();
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("注册失败,两次密码输入不一致!");
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
					System.out.println("-----登陆页面-----");

					System.out.println("请输入用户名: ");
					Scanner reader = new Scanner(System.in);
					String username = reader.next();
					System.out.println("请输入密码: ");
					String password = reader.next();
					ResultSet rs = sql.executeQuery(
							"select * from users where username='" + username + "' and password='" + password + "'");

					if (rs.next()) {
						System.out.println("......登陆中\n");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("登陆成功!\n");
						break;
					} else {
						number = number + 1;
						System.out.println("登陆失败,用户名或密码错误,请认真核对!\n");
//						System.out.println("" + number);
						if (number == 3) {
							System.out.println("登陆失败错误次数过多,即将退出!\n");
							System.exit(0);
							break;
						}
					}
					/*
					 * 正常退出 status为0时为正常退出程序，也就是结束当前正在运行中的java虚拟机。
					 * 
					 * 非正常退出 status为非0的其他整数（包括负数，一般是1或者-1），表示非正常退出当前程序。
					 */
					// 5.断开连接，关闭数据库
					rs.close();
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}

			while (true)

			{
				System.out.println("----------欢迎使用个人成绩信息管理系统----------");

				System.out.println("—— 1-添加课程.\t\t5-查询信息.\t   ——");
				System.out.println("—— 2-添加成绩.\t\t6-修改信息.\t   ——");
				System.out.println("—— 3-查询年平均成绩.\t7-删除信息. \t   ——");
				System.out.println("—— 4-查询按年成绩排序.\t8-修改密码.\t   ——");
				System.out.println("—— 9-退出程序\t\t\t\t   ——");
				System.out.println("---------------------------------------------");
				System.out.println("\n请输入你的指令( 1 ~ 9 ): ______");
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
					System.out.println("感谢使用!Byebye~");
					System.exit(0);

					Connection connection = null;
					Statement statement = null;
					ResultSet set = null;
					try {
						// 1.加载数据库驱动
						Class.forName("com.mysql.jdbc.Driver");
						// 2.通过DriverManager获取数据库连接
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root",
								"dai324542");
						Statement sql = con.createStatement();
					} catch (ClassNotFoundException e) {
						System.out.println("---错误提示:数据库驱动加载失败");
						e.printStackTrace();
					} catch (SQLException e) {
						System.out.println("---错误提示:数据库操作失败");
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
