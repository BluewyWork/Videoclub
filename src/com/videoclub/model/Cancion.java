package com.videoclub.model;

/**
 * Esta clase representa una canción dentro del sistema de videoclub.
 * Contiene información como el título, el autor, el nombre y la duración de la canción.
 */
public class Cancion
{
	private String titulo;
	private String autor;
	private String nombre;
	private float duracion;

	/**
	 * Crea una nueva instancia de la clase Cancion con el nombre y la duración especificados.
	 *
	 * @param nombre   El nombre de la canción.
	 * @param duracion La duración de la canción en segundos.
	 */
	public Cancion(String nombre, float duracion)
	{
		this.nombre = nombre;
		this.duracion = duracion;
	}

	/**
	 * Devuelve el nombre de la canción.
	 *
	 * @return El nombre de la canción.
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * Establece el nombre de la canción.
	 *
	 * @param nombre El nombre de la canción.
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * Devuelve una representación en forma de cadena de la canción.
	 *
	 * @return La representación en forma de cadena de la canción.
	 */
	@Override
	public String toString()
	{
		return "Cancion: " + "\n" +
				super.toString() + "\n" +
				"\t" + "Nombre: '" + nombre + '\'' +
				"\t" + "Duracion: " + duracion;
	}

	/**
	 * Devuelve el título de la canción.
	 *
	 * @return El título de la canción.
	 */
	public String getTitulo()
	{
		return titulo;
	}

	/**
	 * Establece el título de la canción.
	 *
	 * @param titulo El título de la canción.
	 */
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	/**
	 * Devuelve el autor de la canción.
	 *
	 * @return El autor de la canción.
	 */
	public String getAutor()
	{
		return autor;
	}

	/**
	 * Establece el autor de la canción.
	 *
	 * @param autor El autor de la canción.
	 */
	public void setAutor(String autor)
	{
		this.autor = autor;
	}

	/**
	 * Devuelve la duración de la canción en segundos.
	 *
	 * @return La duración de la canción en segundos.
	 */
	public float getDuracion()
	{
		return duracion;
	}

	/**
	 * Establece la duración de la canción en segundos.
	 *
	 * @param duracion La duración de la canción en segundos.
	 * @throws RuntimeException si la duración especificada es menor que 0.
	 */
	public void setDuracion(float duracion)
	{
		if (duracion > 0.0)
		{
			this.duracion = duracion;
		}
		else
		{
			throw new RuntimeException("La duracion de la cancion no puede ser menor que 0");
		}
	}
}
