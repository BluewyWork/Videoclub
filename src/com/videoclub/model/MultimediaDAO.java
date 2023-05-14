package com.videoclub.model;

import java.util.ArrayList;

public class MultimediaDAO
{
	private ArrayList<Multimedia> listMultimedia;

	public MultimediaDAO()
	{
		listMultimedia = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		StringBuilder txt = new StringBuilder();

		for (Multimedia multimedia : listMultimedia)
		{
			txt.append(multimedia.toString()).append("\n\n");
		}

		return txt.toString();
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