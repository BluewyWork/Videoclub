package com.videoclub.model;

/**
 * Esta clase contiene constantes utilizadas en el sistema de videoclub.
 */
public class Constantes
{
	/**
	 * La ruta al directorio de datos de la aplicación.
	 */
	public static final String appDataPath = System.getenv("APPDATA");

	/**
	 * La duración máxima de un alquiler en días.
	 */
	public static final int RENT_MAX_DURATION = 3;

	/**
	 * El precio base de un alquiler.
	 */
	public static final double BASE_PRICE = 4.0;

	/**
	 * El recargo por día de retraso en el pago de un alquiler.
	 */
	public static final double SURCHARGE_PER_DAY = 2;

	/**
	 * La posición X de la ventana principal del sistema.
	 */
	public static final int POSITION_X_WINDOWS = 350;

	/**
	 * La posición Y de la ventana principal del sistema.
	 */
	public static final int POSITION_Y_WINDOWS = 150;

	/**
	 * El ancho de la ventana principal del sistema.
	 */
	public static final int BOUNDS_WIDTH_WINDOWS = 800;

	/**
	 * La altura de la ventana principal del sistema.
	 */
	public static final int BOUNDS_HEIGHT_WINDOWS = 500;
}
