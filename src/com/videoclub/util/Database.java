package com.videoclub.util;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Database
{
	String url = "jdbc:postgresql://localhost:5432/";
	String db = "postgres";
	String driver = "org.postgresql.Driver";
	String user = "postgres";
	String pass = "DAM1234.";

	SocioController socioController;
	MultimediaController multimediaController;
	AlquilerController alquilerController;

	public Database(SocioController sc, MultimediaController mc, AlquilerController ac)
	{
		socioController = sc;
		multimediaController = mc;
		alquilerController = ac;

		// Read configuration file and set attributes
		readConfigFile();
	}

	private void readConfigFile()
	{
		try
		{
			String configFilePath = getConfigFilePath();
			if (configFilePath == null)
			{
				// Use default values
				return;
			}

			BufferedReader reader = new BufferedReader(new FileReader(configFilePath));
			String line;
			while ((line = reader.readLine()) != null)
			{
				line = line.trim();
				if (!line.isEmpty())
				{
					String[] parts = line.split("=");
					if (parts.length == 2)
					{
						String key = parts[0].trim();
						String value = parts[1].trim();
						setAttribute(key, value);
					}
				}
			}
			reader.close();
		}
		catch (Exception e)
		{
			// Failed to read config file, use default values
			e.printStackTrace();
		}
	}

	private String getConfigFilePath()
	{
		String configDir = FolderPathResolver.getUserConfigPath();
		if (configDir != null)
		{
			Path configPath = Paths.get(configDir, "VideoClub", "config.txt");
			return configPath.toString();
		}
		return null;
	}

	private void setAttribute(String key, String value)
	{
		switch (key)
		{
			case "url":
				url = value;
				break;
			case "db":
				db = value;
				break;
			case "driver":
				driver = value;
				break;
			case "user":
				user = value;
				break;
			case "pass":
				pass = value;
				break;
			default:
				// Ignore unrecognized keys
				break;
		}
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
				statement.execute("drop table if exists socio;");

				String query = "";

				query += "create table socio\n" +
						"(\n" +
						"    nif text,\n" +
						"    nombre text,\n" +
						"    fecha_nacimiento date,\n" +
						"\tpoblacion text,\n" +
						"\n" +
						"\tprimary key(nif)\n" +
						");"
				;
				statement.execute(query);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			try
			{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO socio(nif, nombre, fecha_nacimiento, poblacion) VALUES (?, ?, ?, ?)");

				for (Socio socio : listSocio)
				{
					pstmt.setString(1, socio.getNif());
					pstmt.setString(2, socio.getNombre());
					pstmt.setDate(3, java.sql.Date.valueOf(socio.getFechaNacimiento()));
					pstmt.setString(4, socio.getPoblacion());
					pstmt.addBatch(); // Add the prepared statement to the batch
				}

				pstmt.executeBatch(); // Execute the batch

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
				statement.execute("drop table if exists Multimedia;");

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
		ArrayList<Pelicula> listMultimedia = multimediaController.todosLosPelis();
		ArrayList<Alquiler> listAlquiler = alquilerController.todosLosAlquileres();

		Connection connection = null;

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement statement = connection.createStatement();
				statement.execute("drop table if exists pelicula;");

				String query = "";

				query += "create table pelicula\n" +
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
				statement.execute(query);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			try
			{
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO pelicula(titulo, autor, format, anio, duracion, actor_principal, actriz_principal) VALUES (?, ?, ?, ?, ?, ?, ?)");

				for (Multimedia multimedia : listMultimedia)
				{
					if (multimedia instanceof Pelicula)
					{
						pstmt.setString(1, multimedia.getTitulo());
						pstmt.setString(2, multimedia.getAutor());
						pstmt.setString(3, multimedia.getFormat().toString());
						pstmt.setInt(4, (multimedia.getAnio()));
						pstmt.setInt(5, ((Pelicula) multimedia).getDuracion());
						pstmt.setString(6, ((Pelicula) multimedia).getActorPrincipal());
						pstmt.setString(7, ((Pelicula) multimedia).getActrizPrincipal());
						pstmt.addBatch();
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
		ArrayList<Videojuego> listMultimedia = multimediaController.todosLosVideojuegos();
		ArrayList<Alquiler> listAlquiler = alquilerController.todosLosAlquileres();

		Connection connection = null;

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url + db, user, pass);

			try
			{
				Statement statement = connection.createStatement();
				statement.execute("drop table if exists videojuego;");

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
				statement.execute(query);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			try
			{
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO videojuego(titulo, autor, format, anio, plataforma) VALUES (?, ?, ?, ?, ?)");

				for (Multimedia multimedia : listMultimedia)
				{
					if (multimedia instanceof Videojuego)
					{
						pstmt.setString(1, multimedia.getTitulo());
						pstmt.setString(2, multimedia.getAutor());
						pstmt.setString(3, multimedia.getFormat().toString());
						pstmt.setInt(4, (multimedia.getAnio()));
						pstmt.setString(5, ((Videojuego) multimedia).getPlatform().toString());
						pstmt.addBatch();
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
				DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				Statement st = con.createStatement();

				ResultSet res = st.executeQuery("select * from socio;");
				while (res.next())
				{
					String nif = res.getString("nif");
					String nombre = res.getString("nombre");
					String fechaNacimiento = res.getString("fecha_nacimiento");
					String formattedDate = fechaNacimiento.replace("-", "/");
					LocalDate date = LocalDate.parse(formattedDate, sourceFormatter);

					String format2 = date.format(targetFormatter);
					String poblacion = res.getString("poblacion");

					socioController.registrarSocio(nif, nombre, format2, poblacion);
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
					String autor = res.getString("autor");
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
					String autor = res.getString("autor");
					String formato = res.getString("format");
					int anio = Integer.parseInt(res.getString("anio"));
					String plataforma = res.getString("plataforma");

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
					String plataforma = res.getString("plataforma");

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
