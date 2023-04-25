package com.videoclub.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Alquiler {

	private static final AtomicInteger counter = new AtomicInteger(0);
	private int id;
	private Socio mySocio;
	private ArrayList<Multimedia> arrayListMultimediaAlquilada;

	private boolean deuda;

	public Alquiler() {
		setId(getNextId());
		setMySocio(new Socio());
		setDeuda(true);
		arrayListMultimediaAlquilada = new ArrayList<>();
	}

	public Alquiler(Socio mySocio, boolean deuda) {
		this();
		this.mySocio = mySocio;
		this.deuda = deuda;
	}

	@Override
	public String toString() {
		String text = "";

		text += mySocio.toString() + "\n";

		for (int x = 0; x < arrayListMultimediaAlquilada.size(); x++) {
			text += arrayListMultimediaAlquilada.get(x).toString() + "\n";
		}

		return text;
	}

	public boolean isDeuda() {
		return deuda;
	}

	public void setDeuda(boolean deuda) {
		this.deuda = deuda;
	}

	public static int getNextId() {
		return counter.getAndIncrement();
	}

	public Socio getMySocio() {
		return mySocio;
	}

	public void setMySocio(Socio mySocio) {
		this.mySocio = mySocio;
	}

	public ArrayList<Multimedia> getArrayListMultimedia() {
		return arrayListMultimediaAlquilada;
	}

	public void setArrayListMultimedia(ArrayList<Multimedia> arrayListMultimedia) {
		this.arrayListMultimediaAlquilada = arrayListMultimedia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public static Alquiler buscarAlquiler(ArrayList<Alquiler> arrayListAlquiler, int id) {
	// 	Alquiler myAlquiler = null;
	// 	boolean encontrado = false;

	// 	for (int x = 0; x < arrayListAlquiler.size(); x++) {
	// 		if (id == arrayListAlquiler.get(x).getId() && encontrado == false) {
	// 			myAlquiler = arrayListAlquiler.get(x);
	// 			encontrado = true;
	// 		}
	// 	}

	// 	return myAlquiler;
	// }
}