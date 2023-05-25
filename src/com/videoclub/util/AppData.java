package com.videoclub.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppData {

	public static void setUp() {
		String appDataPath = System.getenv("APPDATA");

		String folderName = "Videoclub";
		Path folderPath = Paths.get(appDataPath, folderName);

		try {
			if (!Files.exists(folderPath)) {
				Files.createDirectory(folderPath);
				System.out.println("Carpeta creada correctamente.");
			} else {
				System.out.println("La carpeta ya existe.");
			}
		} catch (Exception e) {
			System.out.println("Error al crear la carpeta: " + e.getMessage());
		}
	}
	public static Path rutaArchivo(){
		String appDataPath = System.getenv("APPDATA");

		String folderName = "Videoclub";
		Path folderPath = Paths.get(appDataPath, folderName);
		return folderPath;
	}
}
