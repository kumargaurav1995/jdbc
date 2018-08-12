package jdbc2;
import java.sql.*;
import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
System.out.println("Enter id,name and age to save");
Scanner scan=new Scanner(System.in);
int id=scan.nextInt();
String name=scan.next();
int age=scan.nextInt();
String url="jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false";
String user="root";
String pass="kskg1009@";
String query1="insert into studentinfo values(?,?,?)";
String query2="select * from studentinfo";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection(url, user, pass);
PreparedStatement st1=con.prepareStatement(query1);
st1.setInt(1, id);
st1.setString(2, name);
st1.setInt(3, age);
int count=st1.executeUpdate();
System.out.println(count+"row/s affected");

Statement st2=con.createStatement();
ResultSet rs=st2.executeQuery(query2);
while(rs.next()){
	System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("age"));
}
scan.close();
st2.close();
con.close();
	}

}
