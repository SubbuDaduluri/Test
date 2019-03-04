package com.acd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acd.conn.DBUtils;
import com.acd.conn.MyUtils;
import com.acd.modal.Department;

@WebServlet(urlPatterns = { "/feedback" })
public class FeedbackServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -425841565289940460L;
	public FeedbackServlet() {
        super();
    }
	  @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
		  Connection conn = MyUtils.getStoredConnection(request);
		  List<Department> departMentList = null;
			try {
				departMentList = DBUtils.findAllDepartments(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("departmentList", departMentList);
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/feedback.jsp");
	        dispatcher.forward(request, response);
	    }
}
