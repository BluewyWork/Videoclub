package com.videoclub.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Test
{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Uneditable Table Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the table data
		Object[][] data = {
				{"John Doe", 25, "Male"},
				{"Jane Smith", 32, "Female"},
				{"Bob Johnson", 42, "Male"}
		};

		// Create the column names
		String[] columnNames = {"Name", "Age", "Gender"};

		// Create the table model with the data and column names
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;  // Make all cells uneditable
			}
		};

		// Create the JTable with the custom table model
		JTable table = new JTable(tableModel);

		// Set table properties
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		// Create a JScrollPane and add the JTable to it
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the JScrollPane to the JFrame's content pane
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		frame.setSize(400, 300);
		frame.setVisible(true);
	}
}