

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Servlet9
 */
public class Servlet9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	PrintWriter out=response.getWriter();
	String id=request.getParameter("id");
	out.print("<h1>Display the Records</h1>");
	out.print("<table border='1'><tr><th>Id</th><th>Name</th><th>Address</th></tr>");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","worship");
		Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from employee1 where id="+id+"");
				while(rs.next())
				{
					out.print("<tr><td>");
					out.println(rs.getInt(1));
					out.print("</td>");
					out.print("<td>");
					out.print(rs.getString(2));
					out.print("</td>");
					out.print("<td>");
					out.print(rs.getString(3));
					out.print("</td>");
					out.print("</tr>");
				}
	}catch(Exception p) {
		System.out.println(p);
	}
	out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
