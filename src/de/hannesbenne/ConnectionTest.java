package de.hannesbenne;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ConnectionTest
 */
@WebServlet("/ConnectionTest")
public class ConnectionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/labelmanager")
    DataSource dataSource;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			statement = connection.createStatement();
			
			String sql = "select * from label";
			
			resultSet = statement.executeQuery(sql);
			
			PrintWriter printWriter = response.getWriter();
			
			while(resultSet.next()) {
				printWriter.println(resultSet.getString("artikelnummer"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("huhu");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
