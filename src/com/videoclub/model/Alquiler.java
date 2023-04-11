package com.videoclub.model;

import java.util.ArrayList;

public class Alquiler {

	private static int alquilerCount = 0;
	private int id;
	private Socio mySocio;
	private ArrayList<Multimedia> arrayListMultimedia;

	public Alquiler() {
		alquilerCount ++;
		mySocio = new Socio();
		arrayListMultimedia = new ArrayList<>();
		id = alquilerCount;
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
}