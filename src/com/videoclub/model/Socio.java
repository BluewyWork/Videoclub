package com.videoclub.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Socio
{
	private String nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String poblacion;
	private ArrayList<Alquiler> alquileres;

	// Constructors
	public Socio()
	{
		nif = "RANDOM";
		nombre = "RANDOM";
		fechaNacimiento = LocalDate.of(2003, 1, 1);
		poblacion = "RANDOM";
		alquileres = new ArrayList<>();
	}

	public Socio(String nIF, String nombre, LocalDate fechaNacimiento, String poblacion)
	{
		nif = nIF;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.poblacion = poblacion;
	}

	public Socio(String nif, String nombre, String fechaNac, String poblacion)
	{
		this();
		this.nif = nif;
		this.nombre = nombre;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate lc = LocalDate.parse(fechaNac, formatter);

		fechaNacimiento = lc;
		this.poblacion = poblacion;
		alquileres = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		return
				"Socio: " + "\n" +
						"\t" + "Nif: " + nif + "\n" +
						"\t" + "Nombre: " + nombre + "\n" +
						"\t" + "FechaNac: " + fechaNacimiento + "\n" +
						"\t" + "Poblacion: " + poblacion;
	}

	public ArrayList<Alquiler> getAlquileres()
	{
		return alquileres;
	}

	public void setAlquileres(ArrayList<Alquiler> alquileres)
	{
		this.alquileres = alquileres;
	}

	public String getNif()
	{
		return nif;
	}

	public void setNif(String nif)
	{
		this.nif = nif;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPoblacion()
	{
		return poblacion;
	}

	public void setPoblacion(String poblacion)
	{
		this.poblacion = poblacion;
	}

	public boolean isMayorEdad()
	{
		Period myPeriod = Period.between(fechaNacimiento, LocalDate.now());

		return myPeriod.getYears() >= 18;
	}

	public void agregarAlquiler(Alquiler alquiler)
	{
		alquileres.add(alquiler);
	}
}