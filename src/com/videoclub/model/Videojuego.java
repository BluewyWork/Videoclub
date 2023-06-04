package com.videoclub.model;

public class Videojuego extends Multimedia
{
	/**
	 * Atributos de la clase plataforma
	 */
	private Plataforma platforma;

	/**
	 * Constructor por defecto de la clase Videojuego
	 */
	public Videojuego()
	{
		super();
		this.platforma = Plataforma.NINTENDO;
	}

	/**
	 * Constructor por parametros de la clase videojuego
	 * @param title
	 * @param author
	 * @param format
	 * @param year
	 * @param platform
	 */
	public Videojuego(String title, String author, String format, int year, String platform)
	{
		super(title, author, format, year);
		setPlatform(Plataforma.valueOf(platform));
	}

	/**
	 * Override del metodo toString
	 * @return
	 */
	@Override
	public String toString()
	{
		String txt = "";

		txt += super.toString() + "\n";
		txt += "Plataforma: " + platforma;

		return txt;
	}

	/**
	 * Get y set
	 * @return
	 */
	public Plataforma getPlatform()
	{
		return platforma;
	}

	public void setPlatform(Plataforma platforma)
	{
		this.platforma = platforma;
	}
}