package com.videoclub.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Logger
{
	private static final String OS = System.getProperty("os.name").toLowerCase();
	private static final boolean IS_WINDOWS = OS.contains("win");
	private static final boolean IS_UNIX = OS.contains("nix") || OS.contains("nux") || OS.contains("aix");

	public static void log(String message)
	{
		try
		{
			Path folderPath = getFolderPath();
			Files.createDirectories(folderPath);

			String logFilePath = folderPath.resolve("xd.txt").toString();
			PrintWriter printWriter = new PrintWriter(new FileWriter(logFilePath, true));
			printWriter.println(message);
			printWriter.close();

			System.out.println("Log saved successfully to the file.");
		}
		catch (IOException e)
		{
			System.err.println("Error writing to the log file: " + e.getMessage());
		}
	}

	private static Path getFolderPath()
	{
		String appDataPath = getLocalAppDataRoute();
		return Paths.get(appDataPath, "VideoClub");
	}

	private static String getLocalAppDataRoute()
	{
		if (IS_WINDOWS)
		{
			return System.getenv("APPDATA");
		}
		else if (IS_UNIX)
		{
			return System.getenv("XDG_DATA_HOME");
		}
		else
		{
			throw new RuntimeException("OS not supported");
		}
	}
}