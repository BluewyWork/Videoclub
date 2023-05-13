package com.videoclub.model;

public class Movie extends Multimedia
{
	private int duration;
	private String maleLead;
	private String femaleLead;

	public Movie()
	{
		super();
		duration = 10;
		maleLead = "Mark";
		femaleLead = "GOD";
	}

	public Movie(String title, String author, Format format, int year, int duration, String maleLead, String femaleLead)
	{
		super(title, author, format, year);
		setDuration(duration);
		setMaleLead(maleLead);
		setFemaleLead(femaleLead);
	}

	public Movie(String title, String author, String format, int year, int duration, String maleLead, String femaleLead)
	{
		super(title, author, format, year);
		setDuration(duration);
		setMaleLead(maleLead);
		setFemaleLead(femaleLead);
	}

	@Override
	public String toString()
	{
		return
				super.toString() +
						"\nDuracion: " + duration +
						"\nActor principal: '" + maleLead + '\'' +
						"\nActriz principal: '" + femaleLead + '\'';
	}

	@Override
	public double calculateRentPrice()
	{
		if (getYear() < 2012)
		{
			return Constants.BASE_PRICE - 1;
		}
		else
		{
			return Constants.BASE_PRICE;
		}
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	public String getMaleLead()
	{
		return maleLead;
	}

	public void setMaleLead(String maleLead)
	{
		this.maleLead = maleLead;
	}

	public String getFemaleLead()
	{
		return femaleLead;
	}

	public void setFemaleLead(String femaleLead)
	{
		this.femaleLead = femaleLead;
	}
}