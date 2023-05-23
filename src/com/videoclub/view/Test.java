import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame
{
	public Test()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Drop-down Button Example");

		// Create a combo box
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("Option 1");
		comboBox.addItem("Option 2");
		comboBox.addItem("Option 3");

		// Create a button
		JButton button = new JButton("Click Me");

		// Add action listener to the button
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// Perform some action when the button is clicked
				System.out.println("Button clicked!");
			}
		});

		// Create a panel and add the combo box and button to it
		JPanel panel = new JPanel();
		panel.add(comboBox);
		panel.add(button);

		// Add the panel to the frame
		getContentPane().add(panel);

		pack();
		setVisible(true);
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() ->
		{
			new Test();
		});
	}
}