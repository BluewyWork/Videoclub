package com.videoclub.model;

public class Movie extends Multimedia implements Comparable<Movie>
{
	private int duracion;
	private String actorPrincipal;
	private String actrizPrincipal;

	public Movie()
	{
		duracion = 10;
		actorPrincipal = "Mark";
		actrizPrincipal = "GOD";
	}

	public Movie(String titulo, String autor, Format formato, int anyo, int duracion, String actorPrincipal, String actrizPrincipal)
	{
		super(titulo, autor, formato, anyo);
		setDuracion(duracion);
		setActorPrincipal(actorPrincipal);
		setActrizPrincipal(actrizPrincipal);
	}

	public Movie(String titulo, String autor, String formato, int anyo, int duracion, String actorPrincipal, String actrizPrincipal)
	{
		super(titulo, autor, formato, anyo);
		setDuracion(duracion);
		setActorPrincipal(actorPrincipal);
		setActrizPrincipal(actrizPrincipal);
	}

	@Override
	public String toString()
	{
		return
				super.toString() +
						"\nDuracion: " + duracion +
						"\nActor principal: '" + actorPrincipal + '\'' +
						"\nActriz principal: '" + actrizPrincipal + '\'';
	}

	@Override
	public int compareTo(Movie o)
	{
		return CharSequence.compare(this.getTitulo(), o.getTitulo());
	}

	public int getDuracion()
	{
		return duracion;
	}

	public void setDuracion(int duracion)
	{
		this.duracion = duracion;
	}

	public String getActorPrincipal()
	{
		return actorPrincipal;
	}

	public void setActorPrincipal(String actorPrincipal)
	{
		this.actorPrincipal = actorPrincipal;
	}

	public String getActrizPrincipal()
	{
		return actrizPrincipal;
	}

	public void setActrizPrincipal(String actrizPrincipal)
	{
		this.actrizPrincipal = actrizPrincipal;
	}
}