import java.sql.*;

class PreparedState{
	String url;
	String username;
	String password;
	Connection con;
	PreparedStatement ps1;
	PreparedStatement ps2;
	Statement st;
	
	public PreparedState(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public void fetchRecords() {
		String q1 = "SELECT * FROM STUDENTS";
		try {
			con = DriverManager.getConnection(url, username, password);
			ps1 = con.prepareStatement(q1);
			ResultSet rs = ps1.executeQuery();
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
//    public void createDB(String name) {
//        try {
//            con = DriverManager.getConnection(url, username, password);
//
//            // Use a PreparedStatement with a placeholder for the database name
//            String q2 = "CREATE DATABASE ?";
//            PreparedStatement ps2 = con.prepareStatement(q2);
//
//            // Set the database name as a parameter
//            ps2.setString(1, name);
//
//            // Execute the prepared statement
//            ps2.execute();
//
//            System.out.println("Database created successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
	public void createDB(String name) {
		try {
			String q2 = "CREATE DATABASE " + name;
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			boolean exe = st.execute(q2);
			
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
//		obj.fetchRecords();
		
		obj.createDB("testmadhur");
		
		
	}
}
