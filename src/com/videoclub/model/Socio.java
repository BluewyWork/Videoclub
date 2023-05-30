package com.videoclub.model;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Socio
{
	/**
	 * atributos de la clase Socio
	 */
	private String nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String poblacion;

	/**
	 * constructor por defecto de la clase Socio
	 */
	public Socio()
	{
		nif = "RANDOM";
		nombre = "RANDOM";
		fechaNacimiento = LocalDate.of(2003, 1, 1);
		poblacion = "RANDOM";
	}

	/**
	 * constructor por parametros de la clase Socio
	 * @param nif
	 * @param nombre
	 * @param fechaNacimiento
	 * @param poblacion
	 * le damos formato a la fecha de dd/MM/yyyy
	 */
	public Socio(String nif, String nombre, String fechaNacimiento, String poblacion)
	{
		this();
		this.nif = nif;
		this.nombre = nombre;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		setFechaNacimiento(LocalDate.parse(fechaNacimiento, formatter));
		this.poblacion = poblacion;
	}

	/**
	 * override del toString
	 * @return
	 */
	@Override
	public String toString()
	{
		return "Socio: " + "\n" +
				"\t" + "Nif: " + nif + "\n" +
				"\t" + "Nombre: " + nombre + "\n" +
				"\t" + "FechaNac: " + fechaNacimiento + "\n" +
				"\t" + "Poblacion: " + poblacion;
	}

	/**
	 * getters y setters
	 * @return
	 */
	public String getNombre()
	{
		return nombre;
	}

	public LocalDate getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	/**
	 * comprobacion en el set para controlar que el socio sea mayor de edad y en caso contrario muestra una
	 * excepcion
	 * @param fechaNacimiento recibe la fecha para la comprobacion
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento)
	{
		if (isAdult(fechaNacimiento) && isValidYear(fechaNacimiento.getYear()))
		{
			this.fechaNacimiento = fechaNacimiento;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Member must be an ADULT (+18) or have a valid year",
					"ERROR", JOptionPane.ERROR_MESSAGE
			);
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

	/**
	 * metodo que devuelve un booleano en funcion de si es mayor de edad o no el socio
	 * @param fechaNacimiento recibe la fecha de nacimiento como parametro para comprobar
	 * @return
	 */
	public boolean isAdult(LocalDate fechaNacimiento)
	{
		Period myPeriod = Period.between(fechaNacimiento, LocalDate.now());
		return myPeriod.getYears() >= 18;
	}

	/**
	 * metodo para comprobar que el año es valido
	 * @param anio
	 * @return
	 */
	private boolean isValidYear(int anio)
	{
		return anio > 1900;
	}
}