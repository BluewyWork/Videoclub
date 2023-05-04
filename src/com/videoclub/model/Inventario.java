package com.videoclub.model;

import com.videoclub.lib.Input;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Multimedia> arrayListMultimedia;
    //private ArrayList<Multimedia> arrayListMultimediaAlquilada;

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
    public void mostrarPeliculas(Socio socio) {
        for (int i = 0; i < arrayListMultimedia.size(); i++) {
            if (arrayListMultimedia.get(i) instanceof Pelicula) {
                System.out.println(arrayListMultimedia.get(i).getTitulo());
            }
        }
        boolean b = false;
        while (!b) {
            String elegirPelicula = Input.readInput("Escriba el titulo de la pelicula a alquilar", "");
            for (int i = 0; i < arrayListMultimedia.size() && !b; i++) {
                if (elegirPelicula.equals(arrayListMultimedia.get(i).getTitulo())) {
                    Alquiler alquiler = new Alquiler(socio, true);
                    alquiler.setArrayListMultimediaAlquilada(arrayListMultimedia.get(i));
                    System.out.println("Pelicula " + arrayListMultimedia.get(i).getTitulo() + " alquilada correctamente");
                    arrayListMultimedia.remove(i);
                    System.out.println(alquiler.toString());
                    System.out.println(arrayListMultimedia.toString());
                    b = true;
                }
            }
            if (!b)
                System.out.println("Tiene que introducir un nombre que se encuentre en el catalogo");
        }
    }

    public void mostrarVideojuegos(Socio socio) {
        for (int i = 0; i < arrayListMultimedia.size(); i++) {
            if (arrayListMultimedia.get(i) instanceof Videojuego)
                System.out.println(arrayListMultimedia.get(i).getTitulo());
        }
        boolean b = false;
        while (!b) {
            String elegirPelicula = Input.readInput("Escriba el titulo del videojuego a alquilar", "");
            for (int i = 0; i < arrayListMultimedia.size() && !b; i++) {
                if (elegirPelicula.equals(arrayListMultimedia.get(i).getTitulo())) {
                    Alquiler alquiler = new Alquiler(socio, true);
                    alquiler.setArrayListMultimediaAlquilada(arrayListMultimedia.get(i));
                    System.out.println("Videojuego " + arrayListMultimedia.get(i).getTitulo() + " alquilada correctamente");
                    arrayListMultimedia.remove(i);
                    System.out.println(alquiler.toString());
                    System.out.println(arrayListMultimedia.toString());
                    b = true;
                }
            }
            if (!b)
                System.out.println("Tiene que introducir un nombre que se encuentre en el catalogo");
        }
    }

    public void mostrarDiscos(Socio socio) {
        for (int i = 0; i < arrayListMultimedia.size(); i++) {
            if (arrayListMultimedia.get(i) instanceof Disco)
                System.out.println(arrayListMultimedia.get(i).getTitulo());
        }
        boolean b = false;
        while (!b) {
            String elegirPelicula = Input.readInput("Escriba el titulo del disco a alquilar", "");
            for (int i = 0; i < arrayListMultimedia.size() && !b; i++) {
                if (elegirPelicula.equals(arrayListMultimedia.get(i).getTitulo())) {
                    Alquiler alquiler = new Alquiler(socio, true);
                    alquiler.setArrayListMultimediaAlquilada(arrayListMultimedia.get(i));
                    System.out.println("Disco " + arrayListMultimedia.get(i).getTitulo() + " alquilada correctamente");
                    arrayListMultimedia.remove(i);
                    System.out.println(alquiler.toString());
                    System.out.println(arrayListMultimedia.toString());
                    b = true;
                }
            }
            if (!b)
                System.out.println("Tiene que introducir un nombre que se encuentre en el catalogo");
        }
    }
}
