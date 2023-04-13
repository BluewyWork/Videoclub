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
		} else if (input.matches("-?\\d+(\\.\\d+)?")) {
			return (T) Double.valueOf(input);
		} else {
			return (T) input;
		}
	}
}
