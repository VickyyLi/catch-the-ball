package box_game;

import java.sql.*;
public class create_database {
	public static void main(String args[]) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbName = "db19204246";
			String username = "u19204246";
			String password = "COMP20300";
			Connection con=DriverManager.getConnection("jdbc:mysql://folding03.ucd.ie:3306/"+dbName, username, password);
			Statement stmt=con.createStatement();
			/*int success = stmt.executeUpdate("CREATE TABLE Catch_the_ball (\n" +
					" PlayerID varchar(255),\n" +
					" Score varchar(255));");
			stmt.executeUpdate("insert into Catch_the_ball (PlayerID, Score) values\n" +
					"('anonymous', '0'),\n" +
					"('anonymous', '0'),\n" +
					"('anonymous', '0');");*/
			ResultSet rs = stmt.executeQuery("select * from Catch_the_ball;");
			while(rs.next()) {
				System.out.println("#############################################");
				System.out.println("PersonID: \t" + rs.getString(1));
				System.out.println("Score: \t\t" + rs.getInt(2));
			}
			System.out.println("#############################################");
			stmt.close();
			con.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}