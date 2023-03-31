package VIDEOCLUB;

public abstract class Multimedia {

    private String titulo;
    private String autor;
    private Formato formato;
    private int anyo;

    public Multimedia() {
        titulo = "Multimedia Vacio";
        autor = "N/a";
        formato = Formato.CD;
        anyo = 9999;
    }

    public Multimedia(String titulo, String autor, Formato formato, int anyo) {
        this();
        setTitulo(titulo);
        setAutor(autor);
        setFormato(formato);
        setAnyo(anyo);
    }

    @Override
    public String toString() {
        return "Multimedia [titulo=" + titulo + ", autor=" + autor + ", formato=" + formato + ", año=" + anyo + "]";
    }

    // Getters and Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int año) {
        this.anyo = año;
    }

    public boolean equal(Multimedia multimedia){
        boolean b = false;
        if (getAutor().equals(multimedia.getAutor()) && getTitulo().equals(multimedia.getTitulo()))
            b = true;
        return b;
    }
}
