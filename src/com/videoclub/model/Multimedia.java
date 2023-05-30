package com.videoclub.model;

public abstract class Multimedia implements Comparable<Multimedia>
{
	/**
	 * atributos de la clase Multimedia
	 */
	private String titulo;
	private String autor;
	private Formato formato;
	private int anio;

	private double precioTotalAlquiler;

	/**
	 * constructor por defecto de la clase Multimedia
	 */
	public Multimedia()
	{
		titulo = "Multimedia Vacio";
		autor = "N/a";
		formato = Formato.CD;
		anio = 2000;
		precioTotalAlquiler = calcularPrecioAlquiler();
	}

	/**
	 * constructor con parámetros de la clase Multimedia
	 * @param titulo
	 * @param autor
	 * @param formato
	 * @param anio
	 */
	public Multimedia(String titulo, String autor, String formato, int anio)
	{
		this();
		setTitulo(titulo);
		setAutor(autor);
		setFormat(Formato.valueOf(formato));
		setAnio(anio);
	}

	/**
	 * override toString
	 * @return
	 */
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

	/**
	 * getters y setters
	 * @return
	 */
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

	public void setAnio(int anio)
	{
		this.anio = anio;
	}

	public double getPrecioTotalAlquiler()
	{
		return precioTotalAlquiler;
	}

	public void setPrecioTotalAlquiler(double precioTotalAlquiler)
	{
		this.precioTotalAlquiler = precioTotalAlquiler;
	}

	/**
	 * método para calcular el precio del alquiler
	 * @return
	 */
	public double calcularPrecioAlquiler()
	{
		return Constantes.BASE_PRICE;
	}

	/**
	 * override del método compareTo
	 * @param other the object to be compared.
	 * @return
	 */
	@Override
	public int compareTo(Multimedia other)
	{
		return this.getTitulo().compareTo(other.getTitulo());
	}
}