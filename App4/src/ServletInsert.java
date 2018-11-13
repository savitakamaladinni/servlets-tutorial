

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInsert
 */
public class ServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		Integer phoneNumber= Integer.parseInt(request.getParameter("phoneNumber"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "worship");
			Statement stmt = con.createStatement();
			String a = "insert into employee values('"+id+"','"+firstName+"','"+lastName+"','"+phoneNumber+"')";
			System.out.println(a);
			int executeUpdate=stmt.executeUpdate(a );
			PrintWriter out=response.getWriter();
			out.println(id);
			out.println(firstName);
			out.println(lastName);
			out.println(phoneNumber);
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
		
	}


