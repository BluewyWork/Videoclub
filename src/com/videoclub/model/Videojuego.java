package com.videoclub.model;

public class Videojuego extends Multimedia
{
	private Plataforma platforma;

	public Videojuego()
	{
		super();
		this.platforma = Plataforma.NINTENDO;
	}

	public Videojuego(String title, String author, String format, int year, String platform)
	{
		super(title, author, format, year);
		setPlatform(Plataforma.valueOf(platform));
	}

	public Videojuego(String title, String author, String format, int year, Plataforma platforma)
	{
		super(title, author, format, year);
		setPlatform(platforma);
	}

	public Videojuego(String title, String author, Formato formato, int year, Plataforma platforma)
	{
		super(title, author, formato, year);
		setPlatform(platforma);
	}

	@Override
	public String toString()
	{
		String txt = "";

		txt += super.toString() + "\n";
		txt += "Plataforma: " + platforma;

		return txt;
	}

	public Plataforma getPlatform()
	{
		return platforma;
	}

	public void setPlatform(Plataforma platforma)
	{
		this.platforma = platforma;
	}
}