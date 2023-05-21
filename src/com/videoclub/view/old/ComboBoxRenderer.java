package com.videoclub.view.old;

import com.videoclub.model.Multimedia;

import javax.swing.*;
import java.awt.*;

public class ComboBoxRenderer extends DefaultListCellRenderer
{
	@Override
	public Component getListCellRendererComponent(
			JList<?> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus
	)
	{
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (value instanceof Multimedia)
		{
			Multimedia multimedia = (Multimedia) value;
			setText(multimedia.getTitulo());
		}
		return this;
	}
}
