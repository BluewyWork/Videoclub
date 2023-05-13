package com.videoclub.model;

public abstract class Multimedia
{
	private String title;
	private String author;
	private Format format;
	private int year;

	private double totalRentPrice;

	public Multimedia()
	{
		title = "Multimedia Vacio";
		author = "N/a";
		format = Format.CD;
		year = 9999;
		totalRentPrice = calculateRentPrice();
	}

	public Multimedia(String title, String author, Format format, int year)
	{
		this();
		setTitle(title);
		setAuthor(author);
		setFormat(format);
		setYear(year);
	}

	public Multimedia(String title, String author, String format, int year)
	{
		this();
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

	public double getTotalRentPrice()
	{
		return totalRentPrice;
	}

	public void setTotalRentPrice(double totalRentPrice)
	{
		this.totalRentPrice = totalRentPrice;
	}

	public double calculateRentPrice()
	{
		return Constants.BASE_PRICE;
	}
}