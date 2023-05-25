package com.videoclub.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger
{
	public static void log(String mensaje)
	{
		try
		{
			AppData.setUp();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		try (

				FileWriter fileWriter = new FileWriter(AppData.rutaArchivo().resolve("xd.txt").toFile(), true);

				PrintWriter printWriter = new PrintWriter(fileWriter)
		)
		{
			printWriter.println(mensaje);
			System.out.println("Log guardado correctamente en el archivo.");

		}
		catch (IOException e)
		{
			System.err.println("Error al escribir en el archivo de log: " + e.getMessage());
		}
	}
}
