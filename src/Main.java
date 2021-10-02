import java.sql.*;
public class Main {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:"+ dbFile);
			System.out.println("\n*** ������ ��ȸ ***");
			Statement stat1 = con.createStatement();
			String sql1 = "select * from g_artists";
			ResultSet rs1 = stat1.executeQuery(sql1);
			while(rs1.next()) {
				String id = rs1.getString("id");
				String name = rs1.getString("name");
				System.out.println(id + " " + name);	
			}
			stat1.close();
			
			System.out.println("\n*** ������ �߰� ***");
			Statement stat2 = con.createStatement();
			String sql2 = "insert into g_artists (name, a_type, a_year, debut, regdate) values ('����','����','1990���', '1995��','2021-09-29 00:15:21');";
			int cnt = stat2.executeUpdate(sql2);
			
			if(cnt > 0) {
				System.out.println("���ο� �����Ͱ� �߰��Ǿ����ϴ�.");
			}
			else {
				System.out.println("[ERROR] ������ �߰� ����!");
			}
			stat2.close();
			System.out.println("\n*** ������ ���� ***");
			Statement stat3 = con.createStatement();
			String sql3 = " update g_artists set debut = '2008�� / �̾�' where name='�Ź�';";
			int cnt3 = stat3.executeUpdate(sql3);
			
			if(cnt3 > 0) {
				System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
			}
			else {
				System.out.println("[ERROR] ������ ���� ����!");
			}
			stat3.close();
			System.out.println("\n*** ������ ���� ***");
			Statement stat4 = con.createStatement();
			String sql4 = "delete from g_artists where name='��ź�ҳ��';";
			int cnt4 = stat3.executeUpdate(sql4);
			
			if(cnt4 > 0) {
				System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
			}
			else {
				System.out.println("[ERROR] ������ ���� ����!");
			}
			stat4.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				}
				catch(Exception e) {}
			}
		}
	}
}
