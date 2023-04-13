package com.videoclub.controller;

import com.videoclub.model.GestorAlquiler;

import java.time.LocalDate;
import java.util.ArrayList;

import com.videoclub.model.*;

public class GestorAlquilerController {
	private static GestorAlquiler myGestorAlquiler;

	public GestorAlquilerController() {
		myGestorAlquiler = new GestorAlquiler();
	}

	public GestorAlquiler getMyGestorAlquiler() {
		return myGestorAlquiler;
	}

	public void setMyGestorAlquiler(GestorAlquiler myGestorAlquiler) {
		this.myGestorAlquiler = myGestorAlquiler;
	}

	
}