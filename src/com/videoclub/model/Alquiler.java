package com.videoclub.model;

import java.util.ArrayList;

public class Alquiler {

	private static int alquilerCount = 0;
	private int id;
	private Socio mySocio;
	private ArrayList<Multimedia> arrayListMultimedia;

	public Alquiler() {
		setId(alquilerCount);
		alquilerCount ++;
		setMySocio(new Socio());
		arrayListMultimedia = new ArrayList<>();
	}

	public Alquiler(Socio mySocio, ArrayList<Multimedia> arrayListMulmedia) {
		this();
		this.mySocio = mySocio;
		this.arrayListMultimedia = arrayListMulmedia;
	}

	@Override
	public String toString() {
		String text = "";

		text += mySocio.toString() + "\n";

		for (int x = 0; x < arrayListMultimedia.size(); x++) {
			text += arrayListMultimedia.get(x).toString() + "\n";
		}

		return text;
	}

	public Socio getMySocio() {
		return mySocio;
	}

	public void setMySocio(Socio mySocio) {
		this.mySocio = mySocio;
	}

	public ArrayList<Multimedia> getArrayListMultimedia() {
		return arrayListMultimedia;
	}

	public void setArrayListMultimedia(ArrayList<Multimedia> arrayListMultimedia) {
		this.arrayListMultimedia = arrayListMultimedia;
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