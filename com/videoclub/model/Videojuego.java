package VIDEOCLUB;

public class Videojuego extends Multimedia implements Comparable<Videojuego>{

    private String plataforma;

    public Videojuego(){
        super();
        this.plataforma = "pc";
    }

    public Videojuego(String titulo, String autor, Formato formato, int anyo, String plataforma){
        super(titulo, autor, formato, anyo);
        setPlataforma(plataforma);
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
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
