package com.videoclub.model;

public class Videojuego extends Multimedia implements Comparable<Videojuego>{

    private Plataforma plataforma;

    public Videojuego(){
        super();
        this.plataforma = Plataforma.NINTENDO;
    }

    public Videojuego(String titulo, String autor, Formato formato, int anyo, Plataforma plataforma){
        super(titulo, autor, formato, anyo);
        setPlataforma(plataforma);
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                super.toString() +
                "plataforma='" + plataforma + '\'' +
                '}';
    }

    @Override
    public int compareTo(Videojuego o) {
        return Integer.compare(this.getAnyo(), o.getAnyo());
    }
}
