package com.videoclub.util;

import java.io.*;

public class Serializador
{
	public static void serializar(Object objeto, String nombreArchivo)
	{
		String rutaArchivo = "$HOME/.local/share/videoclub/" + nombreArchivo;
		try {
			FileOutputStream fs = new FileOutputStream(rutaArchivo);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(objeto);
			os.close();
			fs.close();
			System.out.println("Objeto " + objeto + " serializado correctamente " +
					"en el archivo " + rutaArchivo + " en la siguiente ruta: " +
					System.getProperty("user.dir"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object deserializar(String rutaArchivo) throws IOException, ClassNotFoundException
	{
		try (FileInputStream fi = new FileInputStream(rutaArchivo);
		     ObjectInputStream oi = new ObjectInputStream(fi)){
			return oi.readObject();
		}
	}
}
