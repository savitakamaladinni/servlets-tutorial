import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class DBManager {

	public static void main(String[] args) {
	

	private void addUser(Person p) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "worship");
			Statement stmt = con.createStatement();
			String queryString = "insert into person" + 
			" values ('" + p.getId() + "','" 
					+ p.getFName()
					+ "','" + p.getLName() 
					+ "',')";
			System.out.println(queryString);

			boolean rs = stmt.execute(queryString);//

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}


	private void displayUserDetails() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "worship");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from person");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getInt(4));
		
			con.close();
		} catch (Exception be) {
			System.out.println(be);
		}

	}


	
	}

	

}
