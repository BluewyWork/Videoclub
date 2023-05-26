package com.videoclub.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Logger
{
	public static void log(String message)
	{
		try
		{
			Path folderPath = getLogFolderPath();
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

	private static Path getLogFolderPath()
	{
		String appDataPath = FolderPathResolver.getUserDataPath();
		return Paths.get(appDataPath, "VideoClub");
	}
}