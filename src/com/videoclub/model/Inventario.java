package com.videoclub.model;

import java.util.ArrayList;

public class Inventario {

	private ArrayList<Multimedia> arrayListMultimedia;

	public Inventario() {
		arrayListMultimedia = new ArrayList<>();
	}

	public ArrayList<Multimedia> getArrayListMultimedia() {
		return arrayListMultimedia;
	}

	public void setArrayListMultimedia(ArrayList<Multimedia> arrayListMultimedia) {
		this.arrayListMultimedia = arrayListMultimedia;
	}
}
