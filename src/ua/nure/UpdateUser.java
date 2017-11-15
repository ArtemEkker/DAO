package ua.nure;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
User userhave = new User();
		
		userhave.setNicke(request.getParameter("nicknamehave"));
		userhave.setEmail(request.getParameter("emailhave"));
		userhave.setPhone(request.getParameter("phonehave"));
		
		User userwant = new User();
		
		userwant.setNicke(request.getParameter("nicknamewant"));
		userwant.setEmail(request.getParameter("emailwant"));
		userwant.setPhone(request.getParameter("phonewant"));
		
		MySQLUserDAO.getInctance().updateUser(userhave, userwant);
		doGet(request, response);
	}

}
