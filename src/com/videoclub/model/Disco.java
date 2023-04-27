package com.videoclub.model;

import java.util.ArrayList;

public class Disco extends Multimedia{

    private int duracion;
    private ArrayList<Cancion> listCanciones;

    public Disco() {
        setDuracion();
        listCanciones = new ArrayList<>();
    }

    @Override
    public String toString() {
        return 
            super.toString() + "\n" +
            "\t" + "Duracion: " + duracion +
            "\t" + "Canciones: '" + listCanciones + '\'';
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion() {
        for (Cancion a: listCanciones) {
            duracion += a.getDuracion();
        }
    }

    public ArrayList<Cancion> getListCanciones() {
        return listCanciones;
    }

    public void setListCanciones(ArrayList<Cancion> listCanciones) {
        this.listCanciones = listCanciones;
    }
}
