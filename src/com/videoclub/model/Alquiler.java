package com.videoclub.model;

import java.time.LocalDate;

public class Alquiler
{
	private static int contadorID = 0;
	private final LocalDate fechaDevolucion;
	private int contador;
	private String nif;
	private Multimedia multimedia;
	private double deudaInicial;
	private double deudaFinal;
	private final LocalDate fechaAlquiler;

	public Alquiler()
	{
		setContador(contadorID++);
		nif = "RANDOM";
		multimedia = null;
		deudaInicial = 0;
		deudaFinal = 0;
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
		return "Alquiler{" +
				"contador=" + contador +
				", nif='" + nif + '\'' +
				", multimedia=" + multimedia +
				", deudaInicial=" + deudaInicial +
				", deudaFinal=" + deudaFinal +
				", fechaAlquiler=" + fechaAlquiler +
				", fechaDevolucion=" + fechaDevolucion +
				'}';
	}

	public String listaAlquileres()
	{
		StringBuilder text = new StringBuilder();

		text.append(contador).append("||").append(text.append(multimedia.getTitulo()).append("\n\n"));

		return text.toString();
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
		System.out.println(diasAtrasado());
		return diasAtrasado() > 0;
	}

	public int diasAtrasado()
	{
		return fechaDevolucion.until(LocalDate.now()).getDays();
	}

	public double calcularDeudaInicial()
	{
		double deuda = 0;

		deuda += multimedia.calcularPrecioAlquiler();

		return deuda;
	}

	public double calcularDeudaFinal()
	{
		double deuda = 0;

		if (esAtrasado())
		{
			deuda += diasAtrasado() * Constantes.SURCHARGE_PER_DAY;
		}

		return deuda + deudaInicial;
	}
}