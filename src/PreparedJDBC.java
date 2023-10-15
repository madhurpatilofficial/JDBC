import java.sql.*;

class PreparedState{
	String url;
	String username;
	String password;
	Connection con;
	PreparedStatement ps;
	
	public PreparedState(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public void fetchRecords() {
		String query = "SELECT * FROM STUDENTS";
		try {
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String data=  "";
				for(int i=1;i<6;i++) {
					data += rs.getString(i) + " ";				
				}
				System.out.println(data);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

public class PreparedJDBC {
	public static void main(String[] args) throws SQLException{
		
		String url = "jdbc:mysql://localhost:3306/madhurdb";
		String username = "root";
		String password = "root";
		
		PreparedState obj = new PreparedState(url, username, password);
		obj.fetchRecords();
		
		
	}
}
