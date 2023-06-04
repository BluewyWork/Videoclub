/**
 La clase Input proporciona métodos para leer la entrada del usuario desde la consola.
 */
package com.videoclub.lib;

import java.util.Scanner;

public class Input
{
	Scanner myScanner = new Scanner(System.in);

	/**
	 * Lee la entrada del usuario desde la consola y la devuelve como un objeto del tipo especificado.
	 *
	 * @param prompt El mensaje que se muestra al usuario como indicación.
	 * @return El valor ingresado por el usuario como un objeto del tipo especificado.
	 */
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

	/**
	 * Lee la entrada del usuario desde la consola y la devuelve como un objeto del tipo especificado.
	 * Además, permite especificar el tipo de dato esperado como una cadena de texto.
	 *
	 * @param prompt El mensaje que se muestra al usuario como indicación.
	 * @param type   El tipo de dato esperado ("int", "double", "String" o "boolean").
	 * @return El valor ingresado por el usuario como un objeto del tipo especificado.
	 * @throws RuntimeException si el tipo especificado no es válido.
	 */
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