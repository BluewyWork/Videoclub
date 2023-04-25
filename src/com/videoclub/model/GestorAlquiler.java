package com.videoclub.model;

import java.util.ArrayList;

public class GestorAlquiler {

    private ArrayList<Alquiler> arrayListMultimediaAlquilada;

    public GestorAlquiler(){
        arrayListMultimediaAlquilada = new ArrayList<>();
    }
    public void addAlquiler(Socio socio, boolean deuda) {
        arrayListMultimediaAlquilada.add(new Alquiler(socio, deuda));
    }
}
