import java.sql.*;

//Steps invloved in JDBC Connection
//1. Import packages
//2. define url, username, password
//3. Define connection and pass url, username, password as an argument
//4. Declare a statement
//5. 

import java.sql.*;

class JDBCOperations {

	String url;
	String username;
	String password;
	Statement st;
	Connection con;

	public JDBCOperations(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public void retrieveData() {
		String q1 = "SELECT * FROM STUDENTS";
		try {
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			ResultSet rs = st.executeQuery(q1);

			while (rs.next()) {
				String data = "";
				for (int i = 1; i < 6; i++) {
					data += rs.getString(i) + " ";
				}
				System.out.println(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateRecords() {
		try {
			String q2 = "UPDATE STUDENTS SET FIRST_NAME = 'Timir' WHERE id=1";
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			int update = st.executeUpdate(q2);
			if (con != null) {
				System.out.println("Record Updated");
			} else {
				System.out.println("Not Updated");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteRecords() throws SQLException {
		try {
			String q3 = "DELETE FROM STUDENTS WHERE ID = 3";
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			int delete = st.executeUpdate(q3);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}

public class JDBCConnect {
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/madhurdb";
		String username = "root";
		String password = "root";

		JDBCOperations obj = new JDBCOperations(url, username, password);
		obj.retrieveData();
//		obj.updateRecords();
		obj.deleteRecords();

//		int alterTable = st.executeUpdate(q3);
//		System.out.println(alterTable);

//		for update we don't need ResultSet, ResultSet is only used for retrieving purpose i.e. when using select query
//		int opr = st.executeUpdate(q2);
//		System.out.println(opr);
//
//		ResultSet rs = st.executeQuery(q1);

//          following code retrieves 2nd column data
//		while (rs.next()) {
//			System.out.println(rs.getString(2));
//		}

//          following code retrives the entire table with rows and column, following way it works
//          data variable we took to store each column and concat with other row
//          1st iteration data is empty then rs.getString(1) will fetch 1st clm data, 
//          in 2nd itr data will contain 1st row and getString(2) will fetch 2nd row now 
//          in 3rd it 1st two rows will be merged with getString(3) i.e. 3rd row..
//		while (rs.next()) {
//
//			String data = "";
//			for (int i = 1; i < 6; i++) {
//				data += rs.getString(i) + " ";
//			}
//			System.out.println(data);
//
//		}
	}
}
