package com.kislamr.webapps.dao;

import java.util.ArrayList;
import java.util.Date;

import com.kislamr.webapps.model.Entry;

public interface EntryDao {

	ArrayList<Entry> getListOfEntry();

	Entry getEntryById(long EntryId);

	void addEntry(String title, String text, Date date);

	void removeEntry(long id);

}
