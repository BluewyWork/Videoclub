package com.videoclub.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class Socio
{
	private String nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String poblacion;

	public Socio()
	{
		nif = "RANDOM";
		nombre = "RANDOM";
		fechaNacimiento = LocalDate.of(2003, 1, 1);
		poblacion = "RANDOM";
	}

	public Socio(String nif, String nombre, String fechaNacimiento, String poblacion)
	{
		this();
		this.nif = nif;
		this.nombre = nombre;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		setFechaNacimiento(LocalDate.parse(fechaNacimiento, formatter));
		this.poblacion = poblacion;
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

	public String getNombre()
	{
		return nombre;
	}

	public LocalDate getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento)
	{
		if (isAdult(fechaNacimiento) && isValidYear(fechaNacimiento.getYear()))
		{
			this.fechaNacimiento = fechaNacimiento;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Member must be an ADULT (+18) or have a valid year",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException("Member must be an ADULT (+18) or have a valid year");
		}
	}

	public String getNif()
	{
		return nif;
	}

	public String getPoblacion()
	{
		return poblacion;
	}

	public void setPoblacion(String poblacion)
	{
		this.poblacion = poblacion;
	}

	public boolean isAdult(LocalDate fechaNacimiento)
	{
		Period myPeriod = Period.between(fechaNacimiento, LocalDate.now());
		return myPeriod.getYears() >= 18;
	}

	private boolean isValidYear(int year)
	{
		return year > 1900;
	}
}