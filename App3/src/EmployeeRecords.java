

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeRecords
 */
@WebServlet("/EmployeeRecords")
public class EmployeeRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id= Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		Integer phone= Integer.parseInt(request.getParameter("phone"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "worship");
			Statement stmt = con.createStatement();
			int executeUpdate=stmt.executeUpdate("insert into employee values("+id+","+fname+","+lname+","+phone+")");
			PrintWriter out=response.getWriter();
			out.println(id);
			out.println(fname);
			out.println(lname);
			out.println(phone);
			
			
			
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
		
	}

}
