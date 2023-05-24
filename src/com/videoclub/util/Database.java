package com.videoclub.util;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Database
{
	String url = "jdbc:postgresql://localhost:5432/";
	String db = "bluewy";
	String driver = "org.postgresql.Driver";
	String user = "bluewy";
	String pass = "1234";

	SocioController socioController;
	MultimediaController multimediaController;
	AlquilerController alquilerController;

	public Database(SocioController sc, MultimediaController mc, AlquilerController ac)
	{
		socioController = sc;
		multimediaController = mc;
		alquilerController = ac;
	}

	public void updateSocioTable()
	{
		ArrayList<Socio> listSocio = socioController.todosLosSocios();
		ArrayList<Multimedia> listMultimedia = multimediaController.returnStuff();
		ArrayList<Alquiler> listAlquiler = alquilerController.todosLosAlquileres();

		Connection connection = null;

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement statement = connection.createStatement();

				String query = "";

				query += "create table if not exists socio\n" +
						"(\n" +
						"    nif text,\n" +
						"    nombre text,\n" +
						"    fecha_nacimiento date,\n" +
						"\tpoblacion text,\n" +
						"\n" +
						"\tprimary key(nif)\n" +
						");"
				;
				statement.executeQuery(query);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			try
			{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO socio(nif, nombre, fecha_nacimiento, poblacion) VALUES (?, ?, ?, ?)");

				for (Socio socio : listSocio)
				{
					pstmt.setString(1, socio.getNif());
					pstmt.setString(2, socio.getNombre());
					pstmt.setString(3, socio.getFechaNacimiento().format(formatter));
					pstmt.setString(4, socio.getPoblacion());
					pstmt.executeUpdate();
				}
				pstmt.executeBatch();

				connection.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// base para subclases
	public void updateTableMultimedia()
	{
		ArrayList<Socio> listSocio = socioController.todosLosSocios();
		ArrayList<Multimedia> listMultimedia = multimediaController.returnStuff();
		ArrayList<Alquiler> listAlquiler = alquilerController.todosLosAlquileres();

		Connection connection = null;

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement statement = connection.createStatement();

				String query = "";

				query += "create table if not exists multimedia\n" +
						"(\n" +
						"    titulo text,\n" +
						"    autor text,\n" +
						"    formato date,\n" +
						"\tanio integer,\n" +
						"\n" +
						"\tprimary key(nif)\n" +
						");"
				;
				statement.executeQuery(query);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			try
			{
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO multimedia(titulo, autor, formato, poblacion) VALUES (?, ?, ?, ?)");

				for (Multimedia multimedia : listMultimedia)
				{
					pstmt.setString(1, multimedia.getTitulo());
					pstmt.setString(2, multimedia.getAutor());
					pstmt.setString(3, multimedia.getFormat().toString());
					pstmt.setString(4, Integer.toString(multimedia.getAnio()));
					pstmt.executeUpdate();
				}
				pstmt.executeBatch();

				connection.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateTablePelicula()
	{
		ArrayList<Socio> listSocio = socioController.todosLosSocios();
		ArrayList<Multimedia> listMultimedia = multimediaController.returnStuff();
		ArrayList<Alquiler> listAlquiler = alquilerController.todosLosAlquileres();

		Connection connection = null;

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement statement = connection.createStatement();

				String query = "";

				query += "create table if not exists pelicula\n" +
						"(\n" +
						"    titulo text,\n" +
						"    autor text,\n" +
						"    format text,\n" +
						"    anio integer,\n" +
						"    duracion integer,\n" +
						"    actor_principal text,\n" +
						"    actriz_principal text,\n" +
						"\n" +
						"    primary key(titulo, autor)\n" +
						");"
				;
				statement.executeQuery(query);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			try
			{
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO pelicula(titulo, autor, formato, anio, duracion, actor_principal, actriz_principal) VALUES (?, ?, ?, ?, ?, ?, ?)");

				for (Multimedia multimedia : listMultimedia)
				{
					if (multimedia instanceof Pelicula)
					{
						pstmt.setString(1, multimedia.getTitulo());
						pstmt.setString(2, multimedia.getAutor());
						pstmt.setString(3, multimedia.getFormat().toString());
						pstmt.setString(4, Integer.toString(multimedia.getAnio()));
						pstmt.setString(5, Integer.toString(((Pelicula) multimedia).getDuracion()));
						pstmt.setString(6, ((Pelicula) multimedia).getActorPrincipal());
						pstmt.setString(7, ((Pelicula) multimedia).getActrizPrincipal());
						pstmt.executeUpdate();
					}
				}
				pstmt.executeBatch();

				connection.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateTableVideojuego()
	{
		ArrayList<Socio> listSocio = socioController.todosLosSocios();
		ArrayList<Multimedia> listMultimedia = multimediaController.returnStuff();
		ArrayList<Alquiler> listAlquiler = alquilerController.todosLosAlquileres();

		Connection connection = null;

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement statement = connection.createStatement();

				String query = "";

				query += "create table if not exists videojuego\n" +
						"(\n" +
						"    titulo text,\n" +
						"    autor text,\n" +
						"    format text,\n" +
						"    anio integer,\n" +
						"    plataforma text,\n" +
						"\n" +
						"    primary key(titulo, autor)\n" +
						");"
				;
				statement.executeQuery(query);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			try
			{
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO pelicula(titulo, autor, formato, anio, plataforma) VALUES (?, ?, ?, ?, ?)");

				for (Multimedia multimedia : listMultimedia)
				{
					if (multimedia instanceof Videojuego)
					{
						pstmt.setString(1, multimedia.getTitulo());
						pstmt.setString(2, multimedia.getAutor());
						pstmt.setString(3, multimedia.getFormat().toString());
						pstmt.setString(4, Integer.toString(multimedia.getAnio()));
						pstmt.setString(5, ((Videojuego) multimedia).getPlatform().toString());
						pstmt.executeUpdate();
					}

				}
				pstmt.executeBatch();

				connection.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void loadSocios()
	{
		Connection con = null;

		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from socio;");
				while (res.next())
				{
					String nif = res.getString("nif");
					String nombre = res.getString("nombre");
					String fechaNacimiento = res.getString("fecha_nacimiento");
					String poblacion = res.getString("poblacion");

					socioController.registrarSocio(nif, nombre, fechaNacimiento, poblacion);
				}
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void loadPeliculas()
	{
		Connection con = null;

		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pelicula;");
				while (res.next())
				{
					String titulo = res.getString("titulo");
					String autor = res.getString("nombre");
					String formato = res.getString("format");
					int anio = Integer.parseInt(res.getString("anio"));
					int duracion = Integer.parseInt(res.getString("duracion"));
					String actorPrincipal = res.getString("actor_principal");
					String actrizPrincipal = res.getString("actriz_principal");

					multimediaController.altaPelicula(titulo, autor, formato, anio, duracion, actorPrincipal, actrizPrincipal);
				}
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void loadVideojuegos()
	{
		Connection con = null;

		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from videojuego;");
				while (res.next())
				{
					String titulo = res.getString("titulo");
					String autor = res.getString("nombre");
					String formato = res.getString("format");
					int anio = Integer.parseInt(res.getString("anio"));
					String plataforma = res.getString("platforma");

					multimediaController.altaVideojuego(titulo, autor, formato, anio, plataforma);
				}
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void loadDiscos()
	{
		Connection con = null;

		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from disco;");
				while (res.next())
				{
					String titulo = res.getString("titulo");
					String autor = res.getString("nombre");
					String formato = res.getString("format");
					int anio = Integer.parseInt(res.getString("anio"));
					String plataforma = res.getString("platforma");

					//multimediaController.altaDisco(titulo, autor, formato, anio, plataforma);
				}
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
