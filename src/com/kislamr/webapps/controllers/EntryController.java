package com.kislamr.webapps.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

// Servlet for admin of Entries
@WebServlet("/entries")
public class EntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDaoImpl();
	EntryDao entryDao = new EntryDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = userDao
				.getUserById((String) session.getAttribute("userId"));

		// check if remove entry parameter is set, try parsing to Long
		String gEntry = request.getParameter("remove");

		try {
			long lEntry = Long.parseLong(gEntry);
			entryDao.removeEntry(lEntry);
		} catch (Exception pe) {
			System.out
					.print("Not an actual long value! Cannot remove user matching criteria "
							+ pe);
		}
		ArrayList<Entry> listOfEntry = entryDao.getListOfEntry();
		request.setAttribute("user", user);
		request.setAttribute("listOfEntry", listOfEntry);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/entries.jsp");
		dispatcher.forward(request, response);
		listOfEntry.clear();
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String formTitle = request.getParameter("title");
		String formText = request.getParameter("text");
		String formDate = request.getParameter("date");

		System.out.println("Show me the value: " + formDate);

		// check if add is is requested from the url and null-check, if not
		// return error
		if (request.getParameter("add") != null) {
			if (formTitle.equals("") || formText == null || formText.equals("")
					|| formDate == null || formDate.equals("")) {
				request.setAttribute("error",
						"please fill in all of the values!");
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dateFormDate = null;
				try {
					dateFormDate = sdf.parse(formDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				entryDao.addEntry(formTitle, formText, dateFormDate);
			}

		}
		doGet(request, response);
	}

}
