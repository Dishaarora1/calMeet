import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

	public static int saveUser(String email, String name, String password) {
		int status = 0;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into users(email,name,password) values(?,?,?)");
			ps.setString(1,email);
			ps.setString(2,name);
			ps.setString(3,password);
			status=ps.executeUpdate();
			con.close();
		} catch(Exception e) {
			System.out.println("UserDao ::: Error in saveUser() ::: " + e);
		}
		return status;
	}
	
	public static String loginUser(String email, String password) {
		String name = null;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select name from users where email = ? AND password = ?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
			}
			con.close();
		} catch(Exception e) {
			System.out.println("UserDao ::: Error in saveUser() ::: " + e);
		}
		return name;
	}
	
}
