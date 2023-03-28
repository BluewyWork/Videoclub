import java.time.LocalDate;
import java.time.Period;

public class Socio {

	private String nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String poblacion;

	// Constructors
	public Socio() {
		nif = "RANDOM";
		nombre = "RANDOM";
		fechaNacimiento = LocalDate.of(2003, 1, 1);
		poblacion = "RANDOM";
	}

	public Socio(String nIF, String nombre, LocalDate fechaNacimiento, String poblacion) {
		nif = nIF;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return 
		"Socio: " + "\n" +
		"	nif: " + nif + "\n" +
		"	nombre: " + nombre + "\n" +
		"	fechaNac: " + fechaNacimiento + "\n" +	
		"	poblacion: " + poblacion + "\n";
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

	public boolean isMayorEdad() { 
		Period myPeriod = Period.between(fechaNacimiento, LocalDate.now());

		return myPeriod.getYears() >= 18;
	}
}