package application;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="jdbc:sqlite:database/"+"main_database.db";
		try (Connection conn=DriverManager.getConnection(url)){
			if(conn!=null) {
				
				 String sql = "SELECT * FROM user_pass_table";
			        
			     
			             Statement stmt  = conn.createStatement();
			             ResultSet rs    = stmt.executeQuery(sql);
			            
			            // loop through the result set
			            while (rs.next()) {
			                System.out.println(rs.getString("username") +  "\t" + 
			                                   rs.getString("password") + "\t" );
			                                  
			            }
			            
			            String sql1 = "INSERT INTO user_pass_table VALUES(?,?)";
			            
			          
			                    PreparedStatement pstmt = conn.prepareStatement(sql1); 
			                pstmt.setString(1, "bikalpa");
			                pstmt.setString(2, "pass1");
			                pstmt.executeUpdate();
			
			System.out.println("new database is created");
			} }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
