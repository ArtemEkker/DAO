package ua.nure;

import java.io.IOException;
import java.util.List;
import ua.nure.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adduser")
public class AddUser extends HttpServlet{
	
	public AddUser() {
        super();
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
	/*UserInterface dao =	MySQLUserDAO.getInctance();
	List<User>	list = dao.getAllUsers();*/
	
		user.setNicke(request.getParameter("nickname"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		
		MySQLUserDAO.getInctance().addUser(user);
		
		//FactoryDao.getDao("Mong").addUser();
	}

}
