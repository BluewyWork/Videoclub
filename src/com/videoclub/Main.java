package com.videoclub;

import com.videoclub.lib.Input;
import com.videoclub.view.ConsoleMenu;
import com.videoclub.view.MenuView;

public class Main
{
	public static void main(String[] args)
	{
		String ans = Input.readInput("Console/GUI? [c/g]", "String");

		if (ans.equals("c"))
		{
			ConsoleMenu menu = new ConsoleMenu();
			menu.menuPrincipal();
		}
		else if (ans.equals("g"))
		{
			MenuView app = new MenuView();
			app.setVisible(true);
			app.setBounds(100, 100, 900, 900);
		}
		else
		{
			throw new Error("Not handled");
		}
	}
}