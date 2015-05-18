package com.kislamr.webapps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.kislamr.webapps.model.Entry;
import com.kislamr.webapps.util.DBConnectionUtil;

public class EntryDaoImpl implements EntryDao {

	public EntryDaoImpl() {
	}

	ArrayList<Entry> listOfEntry = new ArrayList<Entry>();

	Connection db = DBConnectionUtil.connect();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	@Override
	public Entry getEntryById(long id) {
		try {
			ps = db.prepareStatement("select * from entry where id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				Entry fEntry = new Entry();
				fEntry.setId(rs.getLong(1));
				fEntry.setTitle(rs.getString(2));
				fEntry.setText(rs.getString(3));
				fEntry.setDate(rs.getDate(3));
				return fEntry;
			} else {
				return null;
			}

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return null;
	}

	@Override
	public ArrayList<Entry> getListOfEntry() {
		try {
			st = db.createStatement();
			ps = db.prepareStatement("SELECT * FROM entry");
			rs = ps.executeQuery();

			while (rs.next()) {
				Entry fEntry = new Entry();
				fEntry.setId(rs.getLong(1));
				fEntry.setTitle(rs.getString(2));
				fEntry.setText(rs.getString(3));
				fEntry.setDate(rs.getDate(4));
				listOfEntry.add(fEntry);
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		for (Entry e : listOfEntry) {
			System.out.println(e.getTitle());
		}
		return listOfEntry;
	}

	@Override
	public void addEntry(String title, String text, Date date) {
		try {
			System.out.println("Inserting new row");
			ps = db.prepareStatement("INSERT INTO entry (title, text, date) VALUES (?, ?, ?)");
			ps.setString(1, title);
			ps.setString(2, text);
			// conversion for programdate to sqldate
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(3, sqlDate);
			rs = ps.executeQuery();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void removeEntry(long id) {
		try {
			ps = db.prepareStatement("DELETE FROM entry WHERE id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

}
