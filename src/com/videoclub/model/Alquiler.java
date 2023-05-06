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
	private boolean deuda;
	private LocalDate fechaAlquiler;

	public Alquiler()
	{
		setId(getNextId());
		setMySocio(new Socio());
		setDeuda(true);
		setFechaAlquiler(fechaDeAlquiler());
		arrayListMultimediaAlquilada = new ArrayList<>();
	}

	public Alquiler(Socio mySocio)
	{
		this();
		setMySocio(mySocio);
		arrayListMultimediaAlquilada = new ArrayList<>();
		setDeuda(true);
	}

	@Override
	public String toString()
	{
		String text = "";

		text += mySocio.toString() + "\n";

		for (int x = 0; x < arrayListMultimediaAlquilada.size(); x++)
		{
			if (arrayListMultimediaAlquilada.get(x) instanceof Pelicula)
			{
				text += ((Pelicula) arrayListMultimediaAlquilada.get(x)).toString() + "\n";
			}
			else if (arrayListMultimediaAlquilada.get(x) instanceof Videojuego)
			{
				text += ((Videojuego) arrayListMultimediaAlquilada.get(x)).toString() + "\n";
			}
			else if (arrayListMultimediaAlquilada.get(x) instanceof Disco)
			{
				text += ((Disco) arrayListMultimediaAlquilada.get(x)).toString() + "\n";
			}
			else
				text += "ERROR";
		}

		return text;
	}

	public LocalDate getFechaAlquiler()
	{
		return fechaAlquiler;
	}

	public void setFechaAlquiler(LocalDate fechaAlquiler)
	{
		this.fechaAlquiler = fechaAlquiler;
	}

	public boolean isDeuda()
	{
		return deuda;
	}

	public void setDeuda(boolean deuda)
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

	public void setArrayListMultimedia(ArrayList<Multimedia> arrayListMultimedia)
	{
		this.arrayListMultimediaAlquilada = arrayListMultimedia;
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

	public LocalDate fechaDeAlquiler()
	{
		LocalDate fechaActual = LocalDate.now();
		return fechaActual;
	}

}

// public static Alquiler buscarAlquiler(ArrayList<Alquiler> arrayListAlquiler, int id) {
// 	Alquiler myAlquiler = null;
// 	boolean encontrado = false;

// 	for (int x = 0; x < arrayListAlquiler.size(); x++) {
// 		if (id == arrayListAlquiler.get(x).getId() && encontrado == false) {
// 			myAlquiler = arrayListAlquiler.get(x);
// 			encontrado = true;
// 		}
// 	}

// 	return myAlquiler;
// }
