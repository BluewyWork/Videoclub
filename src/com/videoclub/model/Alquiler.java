package com.videoclub.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Alquiler
{
	private static final AtomicInteger counter = new AtomicInteger(0);
	private int id;
	private Socio mySocio;
	private ArrayList<Multimedia> arrayListMultimediaAlquilada;
	private double deuda;
	private LocalDate fechaAlquiler;

	public Alquiler()
	{
		setId(getNextId());
		setMySocio(new Socio());
		setDeuda(calcularDeuda());
		fechaAlquiler = LocalDate.now();
		arrayListMultimediaAlquilada = new ArrayList<>();
	}

	public Alquiler(Socio mySocio)
	{
		this();
		setMySocio(mySocio);
	}

	@Override
	public String toString()
	{
		StringBuilder text = new StringBuilder();

		text.append(mySocio.toString()).append("\n");

		for (Multimedia multimedia : arrayListMultimediaAlquilada)
		{
			if (multimedia instanceof Pelicula)
			{
				text.append(multimedia.toString()).append("\n");
			}
			else if (multimedia instanceof Videojuego)
			{
				text.append(multimedia.toString()).append("\n");
			}
			else if (multimedia instanceof Disco)
			{
				text.append(multimedia.toString()).append("\n");
			}
			else
				text.append("ERROR");
		}

		return text.toString();
	}

	public LocalDate getFechaAlquiler()
	{
		return fechaAlquiler;
	}

	public void setFechaAlquiler(LocalDate fechaAlquiler)
	{
		this.fechaAlquiler = fechaAlquiler;
	}

	public double getDeuda()
	{
		return deuda;
	}

	public void setDeuda(double deuda)
	{
		this.deuda = deuda;
	}

	public static int getNextId()
	{
		return counter.getAndIncrement();
	}

	public Socio getMySocio()
	{
		return mySocio;
	}

	public void setMySocio(Socio mySocio)
	{
		this.mySocio = mySocio;
	}

	public ArrayList<Multimedia> getArrayListMultimedia()
	{
		return arrayListMultimediaAlquilada;
	}

	public void setArrayListMultimediaAlquilada(Multimedia multimediaAlquilada)
	{
		this.arrayListMultimediaAlquilada.add(multimediaAlquilada);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public double calcularDeuda()
	{
		return 0.0;
	}

	public boolean tieneDeuda()
	{
		return deuda > 0;
	}
}