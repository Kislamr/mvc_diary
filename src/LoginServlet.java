import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kislamr.webapps.dao.UserDao;
import com.kislamr.webapps.dao.UserDaoImpl;
import com.kislamr.webapps.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDaoImpl();

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId, password;

		userId = request.getParameter("userId");
		password = request.getParameter("password");

		LoginService loginService = new LoginService();
		boolean result = loginService.Authenticate(userId, password);
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("userPassword", password);
			request.setAttribute("userId", userId);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/users");
			dispatcher.forward(request, response);
			return;
		} else {
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
