package com.videoclub.model;

public abstract class Multimedia implements Comparable<Multimedia>
{
	private String titulo;
	private String autor;
	private Formato formato;
	private int anio;

	private double precioTotalAlquiler;

	public Multimedia()
	{
		titulo = "Multimedia Vacio";
		autor = "N/a";
		formato = Formato.CD;
		anio = 9999;
		precioTotalAlquiler = calcularPrecioAlquiler();
	}

	public Multimedia(String titulo, String autor, String format, int anio)
	{
		this();
		setTitulo(titulo);
		setAutor(autor);
		setFormat(Formato.valueOf(format));
		setAnio(anio);
	}

	@Override
	public String toString()
	{
		String text = "";

		text += "Titulo: " + titulo + "\n";
		text += "Autor: " + autor + "\n";
		text += "Formato: " + formato + "\n";
		text += "Ano: " + anio;

		return text;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public String getAutor()
	{
		return autor;
	}

	public void setAutor(String autor)
	{
		this.autor = autor;
	}

	public Formato getFormat()
	{
		return formato;
	}

	public void setFormat(Formato formato)
	{
		this.formato = formato;
	}

	public int getAnio()
	{
		return anio;
	}

	public void setAnio(int año)
	{
		this.anio = año;
	}

	public double getPrecioTotalAlquiler()
	{
		return precioTotalAlquiler;
	}

	public void setPrecioTotalAlquiler(double precioTotalAlquiler)
	{
		this.precioTotalAlquiler = precioTotalAlquiler;
	}

	public double calcularPrecioAlquiler()
	{
		return Constantes.BASE_PRICE;
	}

	@Override
	public int compareTo(Multimedia other)
	{
		return this.getTitulo().compareTo(other.getTitulo());
	}
}