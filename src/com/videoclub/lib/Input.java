package com.videoclub.lib;

import java.util.Scanner;

public class Input
{
	Scanner myScanner = new Scanner(System.in);

	public static <T> T readInput(String prompt)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print(prompt);
		String input = scanner.nextLine();

		if (input.matches("-?\\d+"))
		{
			return (T) Integer.valueOf(input);
		}
		else if (input.matches("-?\\d+(\\.\\d+)?"))
		{
			return (T) Double.valueOf(input);
		}
		else
		{
			return (T) input;
		}
	}

	public static <T> T readInput(String prompt, String type)
	{
		Scanner scanner = new Scanner(System.in);
		T value = null;

		do
		{
			try
			{
				System.out.print(prompt);
				String input = scanner.nextLine();

				value = switch (type)
				{
					case "int" -> (T) Integer.valueOf(input);
					case "double" -> (T) Double.valueOf(input);
					case "String" -> (T) input;
					case "boolean" -> (T) Boolean.valueOf(input);
					default -> throw new RuntimeException("Not a valid TYPE!");
				};

				return value;
			}
			catch (Exception e)
			{
				System.out.println("ERROR: " + e.getMessage());
			}
		}
		while (true);
	}
}