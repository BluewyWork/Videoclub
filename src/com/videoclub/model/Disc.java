package com.videoclub.model;

import java.util.ArrayList;

public class Disc extends Multimedia
{
	private int duration;
	private ArrayList<Song> listSongs;

	public Disc()
	{
		setDuracion();
		listSongs = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		return
				super.toString() + "\n" +
						"\t" + "Duration: " + duration +
						"\t" + "Songs: '" + listSongs + '\'';
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuracion()
	{
		for (Song a : listSongs)
		{
			duration += a.getDuration();
		}
	}

	public ArrayList<Song> getListSongs()
	{
		return listSongs;
	}

	public void setListSongs(ArrayList<Song> listSongs)
	{
		this.listSongs = listSongs;
	}
}