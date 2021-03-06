package com.kislamr.webapps.model;

import java.util.Date;

/** Entry model for the diary/journal **/

public class Entry {
	private		long	id;
	private		String	title;
	private		String	text;
	private		Date	date;
	
	public Entry () {}

	public Entry(long id, String title, String text, Date date) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
