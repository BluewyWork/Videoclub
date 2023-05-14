package com.videoclub.model;

public class Cancion extends Disco
{
	private String name;
	private int duration;

	public Cancion(String name, int duration)
	{
		this.name = name;
		this.duration = duration;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		if (duration > 0)
		{
			this.duration = duration;
		}
		else
		{
			throw new RuntimeException("Song: Duration can't be lower than 0");
		}
	}

	@Override
	public String toString()
	{
		return
				"Cancion: " + "\n" +
						super.toString() + "\n" +
						"\t" + "Nombre: '" + name + '\'' +
						"\t" + "Duracion: " + duration;
	}
}