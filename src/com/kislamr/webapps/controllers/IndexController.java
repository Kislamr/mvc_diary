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

import com.kislamr.webapps.dao.EntryDao;
import com.kislamr.webapps.dao.EntryDaoImpl;
import com.kislamr.webapps.dao.UserDao;
import com.kislamr.webapps.dao.UserDaoImpl;
import com.kislamr.webapps.model.Entry;
import com.kislamr.webapps.model.User;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDaoImpl();
	EntryDao entryDao = new EntryDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("logout") != null
				&& request.getParameter("logout").equals("true")) {
			System.out.println("Logging out");
			HttpSession session = request.getSession();
			session.removeAttribute("userId");
			session.removeAttribute("userPassword");
			request.removeAttribute("userId");
			request.removeAttribute("userPassword");
		}

		HttpSession session = request.getSession();
		User user = userDao
				.getUserById((String) session.getAttribute("userId"));

		ArrayList<Entry> listOfEntry = entryDao.getListOfEntry();
		for (Entry e : listOfEntry) {
			System.out.println(e.getTitle());
		}
		request.setAttribute("user", user);
		request.setAttribute("listOfEntry", listOfEntry);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		listOfEntry.clear();
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
