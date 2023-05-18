package com.videoclub.model;

import java.time.LocalDate;

public class Alquiler
{
	private static int contadorID = 0;
	private int contador;
	private String nif;
	private Multimedia multimedia;
	private double deudaInicial;
	private double deudaFinal;
	private LocalDate fechaAlquiler;
	private final LocalDate fechaDevolucion;

	public Alquiler()
	{
		setContador(contadorID++);
		nif = "RANDOM";
		fechaAlquiler = LocalDate.now();
		fechaDevolucion = LocalDate.now().plusDays(Constantes.RENT_MAX_DURATION);
	}

	public Alquiler(String nif, Multimedia multimedia)
	{
		this();
		setNif(nif);
		setMultimedia(multimedia);
		setDeudaInicial(calcularDeudaInicial());
	}

	@Override
	public String toString()
	{
		StringBuilder text = new StringBuilder();

		text.append("ID: ").append(contador).append("\n\n");

		text.append(multimedia.toString()).append("\n\n");

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

	public double getDeudaInicial()
	{
		return deudaInicial;
	}

	public void setDeudaInicial(double deudaInicial)
	{
		this.deudaInicial = deudaInicial;
	}

	public void setDeudaFinal()
	{
		deudaFinal = calcularDeudaFinal();
	}

	public String getNif()
	{
		return nif;
	}

	public void setNif(String nif)
	{
		this.nif = nif;
	}

	public Multimedia getMultimedia()
	{
		return multimedia;
	}

	public void setMultimedia(Multimedia multimedia)
	{
		this.multimedia = multimedia;
	}

	public int getContador()
	{
		return contador;
	}

	public void setContador(int contador)
	{
		this.contador = contador;
	}

	public boolean esAtrasado()
	{
		return diasAtrasado() > 0;
	}

	public int diasAtrasado()
	{
		return fechaDevolucion.until(LocalDate.now()).getDays();
	}

	public double calcularDeudaInicial()
	{
		double debt = 0;

		debt += multimedia.calcularPrecioAlquiler();

		return debt;
	}

	public double calcularDeudaFinal()
	{
		double debt = 0;

		if (esAtrasado())
		{
			debt += diasAtrasado() * Constantes.SURCHARGE_PER_DAY;
		}

		return debt + deudaInicial;
	}
}