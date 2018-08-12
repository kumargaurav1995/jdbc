package jdbc3dao;


import java.sql.*;
import java.util.Scanner;
public class MyClass {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter id to view name");
		Scanner scan=new Scanner(System.in);
		int id=scan.nextInt();
MyClass myc=new MyClass();
student_dao dao=myc.new student_dao();
student s1=dao.getstudent(id);
System.out.println(s1.name);
		
		
	}
	class student_dao{
		
		public student getstudent(int id) throws SQLException{
			
			student s=new student();
			s.id=id;
			String url="jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
			String user="root";
			String pass="kskg1009@";
			String query="select * from studentinfo where id=?";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url, user, pass);
				PreparedStatement st=con.prepareStatement(query);
				st.setInt(1, id);
				ResultSet rs=st.executeQuery();
				rs.next();
				String name=rs.getString(2);
				s.name=name;
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
			
			
		}
	}
	class student{
		int id;
		String name;
		int age;
	}
	public void setvalues(int id) {
		// TODO Auto-generated method stub
		
	}

}
