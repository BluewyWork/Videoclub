package com.videoclub.model;

public class Cancion extends Disco
{

	private String nombre;
	private int duracion;

	public Cancion(String nombre, int duracion)
	{
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public int getDuracion()
	{
		return duracion;
	}

	public void setDuracion(int duracion)
	{
		if (duracion > 0)
			this.duracion = duracion;
		else throw new RuntimeException("ERROR: la duracion no puede ser menor que 0s.");
	}

	@Override
	public String toString()
	{
		return
				"Cancion: " + "\n" +
						super.toString() + "\n" +
						"\t" + "Nombre: '" + nombre + '\'' +
						"\t" + "Duracion: " + duracion;
	}
}
