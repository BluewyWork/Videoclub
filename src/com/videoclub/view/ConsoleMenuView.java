package com.videoclub.view;

public class ConsoleMenuView
{
	public void menuPrincipal()
	{
		System.out.println("### MENU ###");
		System.out.println("[1] Altas");
		System.out.println("[2] Alquilar Multimedia a Socio");
		System.out.println("[3] Devolver Multimedia a Socio");
		System.out.println("[4] Listar");
		System.out.println("[0] Salir");
		System.out.println("--- ---- ---");
	}

	public void menuAltas()
	{
		System.out.println("### ALTAS MENU ###");
		System.out.println("[1] Alta a Socio");
		System.out.println("[2] Alta a Pelicula");
		System.out.println("[3] Alta a Videojuego");
		System.out.println("[4] Alta a Disco");
		System.out.println("[0] Salir");
		System.out.println("--- ---- ---- ---");
	}

	public void menuListar()
	{
		System.out.println("### LISTAR MENU ###");
		System.out.println("[1] Listado de todos los objetos multimedia");
		System.out.println("[2] Listado de todas las películas ordenadas por título");
		System.out.println("[3] Listado de todas las canciones de un disco por duración");
		System.out.println("[4] Listado de todos los videojuegos ordenados por año");
		System.out.println("[5] Listado de los alquileres actuales de un socio");
		System.out.println("[6] Listado de los socios con recargos pendientes");
		System.out.println("[7] Salir");
		System.out.println("--- ------ ---- ---");
	}
}



