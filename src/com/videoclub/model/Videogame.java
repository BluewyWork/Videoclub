package com.videoclub.model;

public class Videogame extends Multimedia implements Comparable<Videogame>
{
	private Platform plataforma;

	public Videogame()
	{
		super();
		this.plataforma = Platform.NINTENDO;
	}

	public Videogame(String titulo, String autor, String formato, int anyo, String plataforma2)
	{
		super(titulo, autor, formato, anyo);
		setPlataforma(Platform.valueOf(plataforma2));
	}

	public Videogame(String titulo, String autor, String formato, int anyo, Platform plataforma)
	{
		super(titulo, autor, formato, anyo);
		setPlataforma(plataforma);
	}

	public Videogame(String titulo, String autor, Format formato, int anyo, Platform plataforma)
	{
		super(titulo, autor, formato, anyo);
		setPlataforma(plataforma);
	}

	@Override
	public String toString()
	{
		return
				super.toString() + "\n" +
						"\t" + "Plataforma: '" + plataforma + '\'';
	}

	@Override
	public int compareTo(Videogame o)
	{
		return Integer.compare(this.getAnyo(), o.getAnyo());
	}

	public Platform getPlataforma()
	{
		return plataforma;
	}

	public void setPlataforma(Platform plataforma)
	{
		this.plataforma = plataforma;
	}
}