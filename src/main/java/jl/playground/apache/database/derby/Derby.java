package jl.playground.apache.database.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Derby {
	public String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	public String protocol = "jdbc:derby:";
	
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:derby:testDB;create=true")){
			
			System.out.println(conn);
			try {
				Statement stmt = conn.createStatement();
				stmt.execute("CREATE TABLE myTable (id int, name varchar(50))");
			}catch (SQLException e){
				
			}
			
			PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO myTable (id, name) VALUES (?,?)");
			insertStmt.setInt(1, 1);
			insertStmt.setString(2, "mysql");
			insertStmt.execute();
			
			insertStmt.setInt(1, 2);
			insertStmt.setString(2, "derby");
			insertStmt.execute();
			
			
			ResultSet rs = conn.prepareStatement("SELECT id,name FROM myTable").executeQuery();
			
			while (rs.next()){
				System.out.println(String.format("id: %d, Name: %s", rs.getInt("id"),rs.getString("name")));
			}
			
			conn.createStatement().execute("DELETE FROM myTable");
			DriverManager.getConnection("jdbc:derby:testDB;shutdown=true");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
