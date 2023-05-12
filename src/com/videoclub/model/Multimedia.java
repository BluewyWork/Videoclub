package com.videoclub.model;

import java.util.Objects;

public abstract class Multimedia
{
	private String titulo;
	private String autor;
	private Format formato;
	private int anyo;

	public Multimedia()
	{
		titulo = "Multimedia Vacio";
		autor = "N/a";
		formato = Format.CD;
		anyo = 9999;
	}

	public Multimedia(String titulo, String autor, Format formato, int anyo)
	{
		setTitulo(titulo);
		setAutor(autor);
		setFormato(formato);
		setAnyo(anyo);
	}

	public Multimedia(String titulo, String autor, String formato, int anyo)
	{
		setTitulo(titulo);
		setAutor(autor);
		setFormato(Format.valueOf(formato));
		setAnyo(anyo);
	}

	@Override
	public String toString()
	{
		String text = "";

		text += "\t" + "Titulo: " + titulo + "\n";
		text += "\t" + "Autor: " + autor + "\n";
		text += "\t" + "Formato: " + formato + "\n";
		text += "\t" + "Ano: " + anyo;

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

	public Format getFormato()
	{
		return formato;
	}

	public void setFormato(Format formato)
	{
		this.formato = formato;
	}

	public int getAnyo()
	{
		return anyo;
	}

	public void setAnyo(int año)
	{
		this.anyo = año;
	}

	public boolean compararMultimedia(Multimedia myMultimedia2)
	{
		return Objects.equals(myMultimedia2.titulo, this.titulo) && Objects.equals(myMultimedia2.autor, this.autor);
	}
}