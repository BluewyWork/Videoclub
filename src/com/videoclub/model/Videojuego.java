package com.videoclub.model;

public class Videojuego extends Multimedia implements Comparable<Videojuego>
{
	private Plataforma plataforma;

	public Videojuego()
	{
		super();
		this.plataforma = Plataforma.NINTENDO;
	}

	public Videojuego(String titulo, String autor, String formato, int anyo, String plataforma2)
	{
		super(titulo, autor, formato, anyo);
		setPlataforma(Plataforma.valueOf(plataforma2));
	}

	public Videojuego(String titulo, String autor, String formato, int anyo, Plataforma plataforma)
	{
		super(titulo, autor, formato, anyo);
		setPlataforma(plataforma);
	}

	public void setPlataforma(Plataforma plataforma)
	{
		this.plataforma = plataforma;
	}

	public Plataforma getPlataforma()
	{
		return plataforma;
	}

	@Override
	public String toString()
	{
		return
				super.toString() + "\n" +
						"\t" + "Plataforma: '" + plataforma + '\'';
	}

	@Override
	public int compareTo(Videojuego o)
	{
		return Integer.compare(this.getAnyo(), o.getAnyo());
	}
}
