package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		try {
			Connection users = null;
			try {
//				request.setCharacterEncoding("utf-8");
//				Class.forName("com.mysql.jdbc.Driver");
//				users = DriverManager.getConnection("jdbc:mysql://localhost/servlet_db", "root", "");
				users = DBConnection.openConnection();
				String id = request.getParameter("deleteId");
				Statement state = users.createStatement();
				state.executeUpdate("DELETE FROM user_table WHERE id='" + id + "'");
				DBConnection.closeConnection(users, state);
//				state.close();
//				users.close();
				response.sendRedirect("/select");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
