package com.videoclub.model;

public class Pelicula extends Multimedia
{
	private int duracion;
	private String actorPrincipal;
	private String actrizPrincipal;

	public Pelicula()
	{
		super();
		duracion = 10;
		actorPrincipal = "Mark";
		actrizPrincipal = "GOD";
	}

	public Pelicula(String title, String author, Formato formato, int year, int duracion, String actorPrincipal, String actrizPrincipal)
	{
		super(title, author, formato, year);
		setDuracion(duracion);
		setActorPrincipal(actorPrincipal);
		setActrizPrincipal(actrizPrincipal);
	}

	public Pelicula(String title, String author, String format, int year, int duracion, String actorPrincipal, String actrizPrincipal)
	{
		super(title, author, format, year);
		setDuracion(duracion);
		setActorPrincipal(actorPrincipal);
		setActrizPrincipal(actrizPrincipal);
	}

	@Override
	public String toString()
	{
		String txt = "";

		txt += super.toString() + "\n";
		txt += "Duracion: " + duracion + "\n";
		txt += "Actor principal: " + actorPrincipal + "\n";
		txt += "Actriz principal: " + actrizPrincipal;

		return txt;
	}

	@Override
	public double calcularPrecioAlquiler()
	{
		if (getAnio() < 2012)
		{
			return Constantes.BASE_PRICE - 1;
		}
		else
		{
			return Constantes.BASE_PRICE;
		}
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