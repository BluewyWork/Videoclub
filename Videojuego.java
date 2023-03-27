package ej6;

public class Videojuego extends Multimedia{
    private String plataforma;

    public Videojuego(String titulo, String autor, Formato formato, int anio, String plataforma) {
        super(titulo, autor, formato, anio);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Videojuego{" +
                "plataforma='" + plataforma + '\'' +
                '}';
    }
}
