

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String a=request.getParameter("uname");
		String b=request.getParameter("password");
		 if(b.equals("servlet"))
				 {  
		        RequestDispatcher rd=request.getRequestDispatcher("/Servlet2");  
		        rd.forward(request, response);  
		    }  
		    else{  
		        out.print("Sorry UserName or Password Error!");  
		        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
		        rd.include(request, response);  
		                      
		        }  
	}

}
