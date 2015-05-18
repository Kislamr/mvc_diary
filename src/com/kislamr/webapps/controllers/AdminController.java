package com.kislamr.webapps.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kislamr.webapps.dao.UserDao;
import com.kislamr.webapps.dao.UserDaoImpl;
import com.kislamr.webapps.model.User;
import com.kislamr.webapps.service.LoginService;

@WebServlet(urlPatterns = { "/users" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginService loginService = new LoginService();
		String getUsername = (String) session.getAttribute("userId");
		String getUserpassword = (String) session.getAttribute("userPassword");
		System.out.println(getUsername + getUserpassword);

		// check if user is authenticated
		if (loginService.Authenticate((String) session.getAttribute("userId"),
				(String) session.getAttribute("userPassword")) == true) {
			User user = userDao.getUserById((String) session
					.getAttribute("userId"));

			// TODO: check if remove is set, try to delete user
			System.out.println(" DELETING: " + request.getParameter("remove"));
			userDao.removeUser(request.getParameter("remove"));

			ArrayList<User> listOfUser = userDao.getListOfUsers();
			for (User u : listOfUser) {
				System.out.println(u.getUserName());
			}

			request.setAttribute("user", user);
			request.setAttribute("listOfUser", listOfUser);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/users.jsp");
			dispatcher.forward(request, response);
			listOfUser.clear();
			return;
		}
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String formUserId = request.getParameter("userId");
		String formUserName = request.getParameter("userName");
		String formUserPassword = request.getParameter("userPassword");

		if (request.getParameter("add") != null) {
			if (formUserId == null || formUserId.equals("")
					|| formUserName == null || formUserName.equals("")
					|| formUserPassword == null || formUserPassword.equals("")) {
				request.setAttribute("error", "please fill in a value");
			} else {
				// TODO: check if user does not exist, add user.
				if (userDao.getUserById(formUserId) != null) {
					request.setAttribute("error", "User exists!");
				} else {
					userDao.addUser(formUserId, formUserName, formUserPassword);
				}
			}
		}
		doGet(request, response);
	}

}
