package com.videoclub.model;

public abstract class Multimedia {

	private String titulo;
	private String autor;
	private Formato formato;
	private int anyo;

	public Multimedia() {
		titulo = "Multimedia Vacio";
		autor = "N/a";
		formato = Formato.CD;
		anyo = 9999;
	}

	public Multimedia(String titulo, String autor, Formato formato, int anyo) {
		setTitulo(titulo);;
		setAutor(autor);
		setFormato(formato);
		setAnyo(anyo);
	}

	public Multimedia(String titulo, String autor, String formato, int anyo) {
		setTitulo(titulo);;
		setAutor(autor);
		setFormato(Formato.valueOf(formato));
		setAnyo(anyo);
	}

	@Override
	public String toString() {
		return
			"\t" + "Titulo: " + titulo + "\n" +
			"\t" + "Autor: " + autor + "\n" +
			"\t" + "Formato: " + formato + "\n" +
			"\t" + "Ano: " + anyo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int año) {
		this.anyo = año;
	}

	public boolean isEquals(Multimedia myMultimedia2) {
		if (myMultimedia2.titulo == this.titulo && myMultimedia2.autor == this.autor) {
			return true;
		}
		else {
			return false;
		}
	}
}
