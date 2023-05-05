package com.videoclub.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Altas extends JPanel implements ActionListener {

	JButton button;

	public Altas() {
		button = new JButton();
		add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}
}
