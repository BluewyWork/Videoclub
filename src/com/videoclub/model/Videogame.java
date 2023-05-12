package com.videoclub.model;

public class Videogame extends Multimedia implements Comparable<Videogame>
{
	private Platform platform;

	public Videogame()
	{
		super();
		this.platform = Platform.NINTENDO;
	}

	public Videogame(String title, String author, String format, int year, String platform)
	{
		super(title, author, format, year);
		setPlatform(Platform.valueOf(platform));
	}

	public Videogame(String title, String author, String format, int year, Platform platform)
	{
		super(title, author, format, year);
		setPlatform(platform);
	}

	public Videogame(String title, String author, Format format, int year, Platform platform)
	{
		super(title, author, format, year);
		setPlatform(platform);
	}

	@Override
	public String toString()
	{
		return
				super.toString() + "\n" +
						"\t" + "Plataforma: '" + platform + '\'';
	}

	@Override
	public int compareTo(Videogame o)
	{
		return Integer.compare(this.getYear(), o.getYear());
	}

	public Platform getPlatform()
	{
		return platform;
	}

	public void setPlatform(Platform platform)
	{
		this.platform = platform;
	}
}