package com.videoclub.model;

import java.util.ArrayList;

public class Inventario
{
	private ArrayList<Multimedia> arrayListMultimedia;

	public Inventario()
	{
		arrayListMultimedia = new ArrayList<>();
	}

	public ArrayList<Multimedia> getArrayListMultimedia()
	{
		return arrayListMultimedia;
	}

	public void setArrayListMultimedia(ArrayList<Multimedia> arrayListMultimedia)
	{
		this.arrayListMultimedia = arrayListMultimedia;
	}

	public void anadirMultimedia(String type, String titulo, String autor, String formato, int anyo, int duracion, String actorPrincipal, String actrizPrincipal, String plataforma)
	{
		switch (type.toLowerCase())
		{
			case "pelicula":
				Pelicula myPelicula = new Pelicula(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal);
				arrayListMultimedia.add(myPelicula);
				break;
			case "videojuego":
				Videojuego myVideojuego = new Videojuego(titulo, autor, formato, anyo, plataforma);
				arrayListMultimedia.add(myVideojuego);
				break;
			case "disco":
				Disco myDisco = new Disco();
				arrayListMultimedia.add(myDisco);
				break;
		}
	}

	public void removerMultimedia(String titulo)
	{
		boolean encontrado = false;

		for (int x = 0; x < arrayListMultimedia.size() && !encontrado; x++)
		{
			if (arrayListMultimedia.get(x).getTitulo().equals(titulo))
			{
				encontrado = true;

				arrayListMultimedia.remove(x);
			}
		}
	}

	public Multimedia buscarMultimedia(String titulo)
	{
		Multimedia mul = null;
		boolean encontrado = false;

		for (int x = 0; x < arrayListMultimedia.size() && !encontrado; x++)
		{
			if (arrayListMultimedia.get(x).getTitulo().equals(titulo))
			{
				encontrado = true;

				mul = arrayListMultimedia.get(x);
			}
		}
		return mul;
	}

	public String mostrarPeliculas()
	{
		String text = "";

		for (int i = 0; i < arrayListMultimedia.size(); i++)
		{
			if (arrayListMultimedia.get(i) instanceof Pelicula)
			{
				text += "Pelicula: " + arrayListMultimedia.get(i).getTitulo() + "\n";
			}
		}
		return text;
	}

//	public void mostrarVideojuegos(Socio socio)
//	{
//		for (int i = 0; i < arrayListMultimedia.size(); i++)
//		{
//			if (arrayListMultimedia.get(i) instanceof Videojuego)
//				System.out.println(arrayListMultimedia.get(i).getTitulo());
//		}
//		boolean b = false;
//		while (!b)
//		{
//			String elegirPelicula = Input.readInput("Escriba el titulo del videojuego a alquilar", "String");
//			for (int i = 0; i < arrayListMultimedia.size() && !b; i++)
//			{
//				if (elegirPelicula.equals(arrayListMultimedia.get(i).getTitulo()))
//				{
//					Alquiler alquiler = new Alquiler(socio);
//					alquiler.setArrayListMultimediaAlquilada(arrayListMultimedia.get(i));
//					socio.agregarAlquiler(alquiler);
//					System.out.println("Videojuego " + arrayListMultimedia.get(i).getTitulo() + " alquilada correctamente");
//					arrayListMultimedia.remove(i);
//					b = true;
//				}
//			}
//			if (!b)
//				System.out.println("Tiene que introducir un nombre que se encuentre en el catalogo");
//		}
//	}
//
//	public void mostrarDiscos(Socio socio)
//	{
//		for (int i = 0; i < arrayListMultimedia.size(); i++)
//		{
//			if (arrayListMultimedia.get(i) instanceof Disco)
//				System.out.println(arrayListMultimedia.get(i).getTitulo());
//		}
//		boolean b = false;
//		while (!b)
//		{
//			String elegirPelicula = Input.readInput("Escriba el titulo del disco a alquilar", "String");
//			for (int i = 0; i < arrayListMultimedia.size() && !b; i++)
//			{
//				if (elegirPelicula.equals(arrayListMultimedia.get(i).getTitulo()))
//				{
//					Alquiler alquiler = new Alquiler(socio);
//					alquiler.setArrayListMultimediaAlquilada(arrayListMultimedia.get(i));
//					socio.agregarAlquiler(alquiler);
//					System.out.println("Disco " + arrayListMultimedia.get(i).getTitulo() + " alquilada correctamente");
//					arrayListMultimedia.remove(i);
//					b = true;
//				}
//			}
//			if (!b)
//				System.out.println("Tiene que introducir un nombre que se encuentre en el catalogo");
//		}
//	}
}
