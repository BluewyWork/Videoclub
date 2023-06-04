package com.videoclub.model;

public class Pelicula extends Multimedia
{
	/**
	 * Atributos de la clase Pelicula
	 */
	private int duracion;
	private String actorPrincipal;
	private String actrizPrincipal;

	/**
	 * Constructor por defecto de la clase Pelicula
	 */
	public Pelicula()
	{
		super();
		duracion = 10;
		actorPrincipal = "Mark";
		actrizPrincipal = "GOD";
	}

	/**
	 * Constructor por parametros de la clase Pelicula
	 * @param titulo
	 * @param autor
	 * @param formato
	 * @param anio
	 * @param duracion
	 * @param actor
	 * @param actriz
	 */
	public Pelicula(String titulo, String autor, String formato, int anio, int duracion, String actor, String actriz)
	{
		super(titulo, autor, formato, anio);
		setDuracion(duracion);
		setActorPrincipal(actor);
		setActrizPrincipal(actriz);
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
		txt += "Duracion: " + duracion + "\n";
		txt += "Actor principal: " + actorPrincipal + "\n";
		txt += "Actriz principal: " + actrizPrincipal;

		return txt;
	}

	/**
	 * Metodo para calcular el precio del alquiler de las multimedias
	 * @return devuelve el precio
	 */
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

	/**
	 * Getters y setters
	 * @return
	 */
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