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

	@Override
	public double calculateRentPrice()
	{
		if (duration < 30)
		{
			return Constants.BASE_PRICE - 1;
		}
		else
		{
			return Constants.BASE_PRICE;
		}
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