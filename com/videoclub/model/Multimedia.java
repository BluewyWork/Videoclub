package com.videoclub.model;

public abstract class Multimedia {

	private String titulo;
	private String autor;
	private Formato formato;
	private int ano;

	public Multimedia() {
		titulo = "Multimedia Vacio";
		autor = "N/a";
		formato = Formato.CD;
		ano = 9999;
	}

	public Multimedia(String titulo, String autor, Formato formato, int ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.formato = formato;
		this.ano = ano;
	}

	@Override
	public String toString() {
		return
			"Multimedia: " + "\n" +
			"	Titulo: " + titulo + "\n" +
			"	Autor: " + autor + "\n" +
			"	Formato: " + formato + "\n" +
			"	Ano: " + ano;
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

	public int getAno() {
		return ano;
	}

	public void setAño(int año) {
		this.ano = año;
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
