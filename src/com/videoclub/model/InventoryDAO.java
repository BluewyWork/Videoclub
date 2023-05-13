package com.videoclub.model;

import java.util.ArrayList;

public class InventoryDAO
{
	private ArrayList<Multimedia> listMultimedia;

	public InventoryDAO()
	{
		listMultimedia = new ArrayList<>();
	}

	public ArrayList<Multimedia> getListMultimedia()
	{
		return listMultimedia;
	}

	public void setListMultimedia(ArrayList<Multimedia> listMultimedia)
	{
		this.listMultimedia = listMultimedia;
	}

	public Multimedia findMultimedia(String title, String author)
	{
		for (Multimedia multimedia : listMultimedia)
		{
			if (multimedia.getTitle().equalsIgnoreCase(title) && multimedia.getAuthor().equalsIgnoreCase(author))
			{
				return multimedia;
			}
		}
		return null;
	}

	public void addMultimedia(Multimedia multimedia)
	{
		listMultimedia.add(multimedia);
	}

	public void eraseMultimedia(String title, String author)
	{
		Multimedia multimedia = findMultimedia(title, author);

		if (multimedia != null)
		{
			listMultimedia.remove(multimedia);
		}
		else
		{
			throw new RuntimeException("Multimedia Not Found");
		}
	}
}