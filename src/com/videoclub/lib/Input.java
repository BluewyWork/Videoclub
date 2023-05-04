package com.videoclub.lib;

import java.util.Scanner;

public class Input {
	Scanner myScanner = new Scanner(System.in);

	public static <T> T readInput(String prompt) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(prompt);
		String input = scanner.nextLine();

		if (input.matches("-?\\d+")) {
			return (T) Integer.valueOf(input);
		} 
		else if (input.matches("-?\\d+(\\.\\d+)?")) {
			return (T) Double.valueOf(input);
		} 
		else {
			return (T) input;
		}
	}

	public static <T> T readInput(String prompt, String type) {
		Scanner scanner = new Scanner(System.in);
		T tipo = null;

		do {
			try {
				System.out.print(prompt);
				String input = scanner.nextLine();

				if (type.equals("int")) {
					tipo = (T) Integer.valueOf(input);
				} 
				else if (type.equals("double")) {
					tipo = (T) Double.valueOf(input);
				} 
				else if (type.equals("String")) {
					tipo =  (T) input;
				}
				else {
					throw new RuntimeException("Not a valid TYPE!");
				}

				return tipo;
			}
			catch (Exception e) {
				System.out.println("ERROR " + e.toString());
			}
		}
		while (true);
	}
}
