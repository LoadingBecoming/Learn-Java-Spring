package testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkDbServlet
 */
@WebServlet("/checkDbServlet")
public class checkDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variables
				String user = "root";
				String pass = "nguyen22002";
				
				String jdbcUrl = "jdbc:mysql://localhost:3306/data_student?useSSL=false";
				String driver = "com.mysql.jdbc.Driver";
				
				// get connection to database
				try {
					PrintWriter out = response.getWriter();
					
					out.println("Connecting to database: " + jdbcUrl);
					
					Class.forName(driver);
					
					Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
					
					out.println("SUCCESS!!");
					
					myConn.close();
					
				}
				catch(Exception e) {
					e.printStackTrace();	
					throw new ServletException(e);
				}
	}

}
