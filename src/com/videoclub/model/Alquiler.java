package com.videoclub.model;

import java.time.LocalDate;

/**
 * Representa un alquiler de multimedia realizado por un socio.
 */
public class Alquiler {
	private static int contadorID = 0;
	private final LocalDate fechaDevolucion;
	private final LocalDate fechaAlquiler;
	private int contador;
	private String nif;
	private Multimedia multimedia;
	private double deudaInicial;
	private double deudaFinal;
	private String tipo;

	/**
	 * Crea un nuevo objeto Alquiler con valores predeterminados.
	 * El contador ID se incrementa y se asigna la fecha actual como fecha de alquiler y fecha de devolución.
	 */
	public Alquiler() {
		setContador(contadorID++);
		nif = "RANDOM";
		multimedia = null;
		deudaInicial = 0;
		deudaFinal = 0;
		fechaAlquiler = LocalDate.now();
		fechaDevolucion = LocalDate.now().plusDays(Constantes.RENT_MAX_DURATION);
	}

	/**
	 * Crea un nuevo objeto Alquiler con el NIF del socio y la multimedia proporcionados.
	 * Se asigna la fecha actual como fecha de alquiler y fecha de devolución.
	 *
	 * @param nif        NIF del socio que realiza el alquiler
	 * @param multimedia Multimedia que se alquila
	 */
	public Alquiler(String nif, Multimedia multimedia) {
		this();
		setNif(nif);
		setMultimedia(multimedia);
		setDeudaInicial(calcularDeudaInicial());
		setTipo();
	}

	/**
	 * Devuelve una representación en formato de cadena del objeto Alquiler.
	 *
	 * @return Cadena que representa el objeto Alquiler
	 */
	@Override
	public String toString() {
		return "Alquiler{" +
				"contador=" + contador +
				", nif='" + nif + '\'' +
				", multimedia=" + multimedia +
				", deudaInicial=" + deudaInicial +
				", deudaFinal=" + deudaFinal +
				", fechaAlquiler=" + fechaAlquiler +
				", fechaDevolucion=" + fechaDevolucion +
				'}';
	}

	/**
	 * Devuelve una representación de cadena de la información del alquiler para su visualización en una lista.
	 *
	 * @return Cadena que representa la información del alquiler para su visualización en una lista
	 */
	public String listaAlquileres() {
		StringBuilder text = new StringBuilder();

		text.append(contador).append("||").append(text.append(multimedia.getTitulo()).append("\n\n"));

		return text.toString();
	}

	/**
	 * Obtiene la deuda inicial del alquiler.
	 *
	 * @return Deuda inicial del alquiler
	 */
	public double getDeudaInicial() {
		return deudaInicial;
	}

	/**
	 * Establece la deuda inicial del alquiler.
	 *
	 * @param deudaInicial Deuda inicial del alquiler
	 */
	public void setDeudaInicial(double deudaInicial) {
		this.deudaInicial = deudaInicial;
	}

	/**
	 * Establece la deuda final del alquiler.
	 * La deuda final se calcula automáticamente en función de la deuda inicial y los días de retraso.
	 */
	public void setDeudaFinal() {
		deudaFinal = calcularDeudaFinal();
	}

	/**
	 * Obtiene el NIF del socio que realizó el alquiler.
	 *
	 * @return NIF del socio
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * Establece el NIF del socio que realiza el alquiler.
	 *
	 * @param nif NIF del socio
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * Obtiene la multimedia alquilada.
	 *
	 * @return Multimedia alquilada
	 */
	public Multimedia getMultimedia() {
		return multimedia;
	}

	/**
	 * Establece la multimedia alquilada.
	 *
	 * @param multimedia Multimedia alquilada
	 */
	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}

	/**
	 * Obtiene el contador del alquiler.
	 *
	 * @return Contador del alquiler
	 */
	public int getContador() {
		return contador;
	}

	/**
	 * Establece el contador del alquiler.
	 *
	 * @param contador Contador del alquiler
	 */
	public void setContador(int contador) {
		this.contador = contador;
	}

	/**
	 * Comprueba si el alquiler está atrasado.
	 *
	 * @return true si el alquiler está atrasado, false en caso contrario
	 */
	public boolean esAtrasado() {
		return diasAtrasado() > 0;
	}

	/**
	 * Obtiene el tipo del objeto de multimedia.
	 *
	 * @return Contador del alquiler
	 */
	public String getTipo()
	{
		return tipo;
	}

	/**
	 * Establece el tipo de la multimedia
	 */
	public void setTipo()
	{
		if (multimedia instanceof Pelicula)
		{
			tipo = "Pelicula";
		}
		else if (multimedia instanceof Videojuego)
		{
			tipo = "Videojuego";
		}
		else if (multimedia instanceof Disco)
		{
			tipo = "Disco";
		}
	}

	/**
	 * Calcula los días de retraso del alquiler.
	 *
	 * @return Número de días de retraso del alquiler
	 */
	public int diasAtrasado() {
		return fechaDevolucion.until(LocalDate.now()).getDays();
	}

	/**
	 * Calcula la deuda inicial del alquiler.
	 *
	 * @return Deuda inicial del alquiler
	 */
	public double calcularDeudaInicial() {
		double deuda = 0;
		deuda += multimedia.calcularPrecioAlquiler();
		return deuda;
	}

	/**
	 * Calcula la deuda final del alquiler.
	 *
	 * @return Deuda final del alquiler
	 */
	public double calcularDeudaFinal() {
		double deuda = 0;
		if (esAtrasado()) {
			deuda += diasAtrasado() * Constantes.SURCHARGE_PER_DAY;
		}
		return deuda + deudaInicial;
	}
}
