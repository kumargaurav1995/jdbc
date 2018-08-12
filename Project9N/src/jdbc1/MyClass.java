package jdbc1;
import java.sql.*;
public class MyClass {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false";
		String user="root";
		String pass="kskg1009@";
		String query="select name from studentinfo where id=4";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection(url,user,pass);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
while(rs.next()){
	System.out.println(rs.getString("name"));
}
	st.close();	
		con.close();
	}

}
