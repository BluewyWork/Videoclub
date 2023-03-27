package ej6;
import java.time.LocalDate;
public class Multimedia {
    private String titulo;
    private String autor;
    private int anyo;
    private Formato formato;
    private double precioBase = 4.0;

    public Multimedia(String titulo,String autor, Formato formato, int anyo){
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anyo;
        this.formato = formato;
    }

    public double calcularPrecioAlquiler(int dias) {
        double precioTotal = precioBase;
        if (dias > 3) {
            // si se alquila por más de 3 días, se cobra 1€ extra por día adicional
            precioTotal += (dias - 3);
        }

        if ((this instanceof Pelicula && anyo < 2012) || (this instanceof Videojuego && anyo < 2010)) {
            // si es pelicula anterior a 2012 o videojuego anterior a 2010, se descuenta 1€ del precio total
            precioTotal -= 1;
        }

        return precioTotal;
    }

    /*
    public double calcularRecargo(LocalDate fechaDevolucion) {
        LocalDate fechaLimite = LocalDate.now().plusDays(3);
        if (fechaDevolucion.isBefore(fechaLimite)) {
            // si se devuelve dentro del plazo de 3 días, no hay recargo
            return 0.0;
        } else {
            // si se devuelve fuera del plazo, se calcula el número de días de retraso y se aplica un recargo de 2€ por día adicional
            int diasRetraso = (int) fechaLimite.until(fechaDevolucion).getDays();
            return 2.0 * diasRetraso;
        }
    }

     */

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

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anyo=" + anyo +
                ", formato=" + formato +
                '}';
    }

    public boolean equals(Multimedia multimedia) {
        return this.titulo.equals(multimedia.getTitulo()) && this.autor.equals(multimedia.getAutor());
    }
}
