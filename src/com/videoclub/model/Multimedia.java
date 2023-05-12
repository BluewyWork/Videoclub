package com.videoclub.model;

import java.util.Objects;

public abstract class Multimedia
{
	private String title;
	private String author;
	private Format format;
	private int year;

	public Multimedia()
	{
		title = "Multimedia Vacio";
		author = "N/a";
		format = Format.CD;
		year = 9999;
	}

	public Multimedia(String title, String author, Format format, int year)
	{
		setTitle(title);
		setAuthor(author);
		setFormat(format);
		setYear(year);
	}

	public Multimedia(String title, String author, String format, int year)
	{
		setTitle(title);
		setAuthor(author);
		setFormat(Format.valueOf(format));
		setYear(year);
	}

	@Override
	public String toString()
	{
		String text = "";

		text += "\t" + "Titulo: " + title + "\n";
		text += "\t" + "Autor: " + author + "\n";
		text += "\t" + "Formato: " + format + "\n";
		text += "\t" + "Ano: " + year;

		return text;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Format getFormat()
	{
		return format;
	}

	public void setFormat(Format format)
	{
		this.format = format;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int año)
	{
		this.year = año;
	}
}