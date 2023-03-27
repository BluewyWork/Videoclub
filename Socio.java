package ej6;
import java.time.LocalDate;
import java.time.Period;

public class Socio {
    private String nif;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String poblacion;

    public Socio(String nif, String nombre, LocalDate fechaNacimiento, String poblacion) {
        this.nif = nif;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.poblacion = poblacion;
    }

    public boolean esMayorDeEdad() {
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, hoy);
        return edad.getYears() >= 18;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }



    @Override
    public String toString() {
        return "Socio{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }
}
