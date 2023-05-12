package com.videoclub.util;

import com.videoclub.model.Constants;

import java.io.*;

public class Serializador
{
	public static void serializar(Object objeto, String nombreArchivo)
	{
		String rutaArchivo = Constants.BASE_PATH + nombreArchivo + Constants.FILE_FORMAT;
		try
		{
			FileOutputStream fs = new FileOutputStream(rutaArchivo);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(objeto);
			os.close();
			fs.close();
			System.out.println("Objeto " + objeto + " serializado correctamente " +
					"en el archivo " + rutaArchivo + " en la siguiente ruta: " +
					System.getProperty("user.dir"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static Object deserializar(String nombreArchivo)
	{
		Object object = null;
		String rutaArchivo = Constants.BASE_PATH + nombreArchivo + Constants.FILE_FORMAT;
		try {
			FileInputStream fi = new FileInputStream(rutaArchivo);
			ObjectInputStream oi = new ObjectInputStream(fi);
			object = oi.readObject();
			oi.close();
			fi.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return object;
	}
}
