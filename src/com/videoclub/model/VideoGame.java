package com.videoclub.model;

public class VideoGame extends Multimedia
{
	private Platform platform;

	public VideoGame()
	{
		super();
		this.platform = Platform.NINTENDO;
	}

	public VideoGame(String title, String author, String format, int year, String platform)
	{
		super(title, author, format, year);
		setPlatform(Platform.valueOf(platform));
	}

	public VideoGame(String title, String author, String format, int year, Platform platform)
	{
		super(title, author, format, year);
		setPlatform(platform);
	}

	public VideoGame(String title, String author, Format format, int year, Platform platform)
	{
		super(title, author, format, year);
		setPlatform(platform);
	}

	@Override
	public String toString()
	{
		String txt = "";

		txt += super.toString() + "\n";
		txt += "Plataforma: " + platform;

		return txt;
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