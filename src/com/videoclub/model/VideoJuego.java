package com.videoclub.model;

public class VideoJuego extends Multimedia
{
	private Platforma platforma;

	public VideoJuego()
	{
		super();
		this.platforma = Platforma.NINTENDO;
	}

	public VideoJuego(String title, String author, String format, int year, String platform)
	{
		super(title, author, format, year);
		setPlatform(Platforma.valueOf(platform));
	}

	public VideoJuego(String title, String author, String format, int year, Platforma platforma)
	{
		super(title, author, format, year);
		setPlatform(platforma);
	}

	public VideoJuego(String title, String author, Formato formato, int year, Platforma platforma)
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

	public Platforma getPlatform()
	{
		return platforma;
	}

	public void setPlatform(Platforma platforma)
	{
		this.platforma = platforma;
	}
}