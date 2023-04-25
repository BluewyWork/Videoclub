package com.videoclub.model;

import com.videoclub.lib.Input;

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

    public void anadirMultimedia(String type, String titulo, String autor, String formato, int anyo, int duracion, String actorPrincipal, String actrizPrincipal, String plataforma) {
        switch (type.toLowerCase()) {
            case "pelicula":
                Pelicula myPelicula = new Pelicula(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal);
                arrayListMultimedia.add(myPelicula);
                break;
            case "videojuego":
                Videojuego myVideojuego = new Videojuego(titulo, autor, formato, anyo, plataforma);
                arrayListMultimedia.add(myVideojuego);
                break;
            case "disco":
                Disco myDisco = new Disco();
                arrayListMultimedia.add(myDisco);
                break;
        }
    }

    /*public void mostrarPeliculas(){
        int n = arrayListMultimedia.size();
        int [] enteros = new int[n];
        int contadorPelis = 0;

        for (int i = 0; i < arrayListMultimedia.size(); i++){
            if (arrayListMultimedia.get(i) instanceof Pelicula) {
                System.out.println(contadorPelis + " " + arrayListMultimedia.get(i).getTitulo());
                enteros [contadorPelis] = i;
                contadorPelis++;
            }
        }
        System.out.println(enteros);
    }*/
    public void mostrarPeliculas() {
        for (int i = 0; i < arrayListMultimedia.size(); i++) {
            if (arrayListMultimedia.get(i) instanceof Pelicula) {
                System.out.println(arrayListMultimedia.get(i).getTitulo());
            }
        }
        String elegirPelicula = Input.readInput("Escriba el titulo de la pelicula a alquilar");
        boolean b = false;
        for (int i = 0; i < arrayListMultimedia.size() && !b; i++) {
            if (elegirPelicula.equals(arrayListMultimedia.get(i).getTitulo())) {

                b = true;
            }
        }
        if (!b)
            System.out.println("Tiene que introducir un nombre que se encuentre en el catalogo");
    }

    public void mostrarVideojuegos() {
        for (int i = 0; i < arrayListMultimedia.size(); i++) {
            if (arrayListMultimedia.get(i) instanceof Videojuego)
                System.out.println(arrayListMultimedia.get(i).getTitulo());
        }
    }

    public void mostrarDiscos() {
        for (int i = 0; i < arrayListMultimedia.size(); i++) {
            if (arrayListMultimedia.get(i) instanceof Disco)
                System.out.println(arrayListMultimedia.get(i).getTitulo());
        }
    }
}
