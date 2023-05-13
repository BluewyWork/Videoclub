package com.videoclub.model;

import java.util.ArrayList;

public class RentDAO
{
	private ArrayList<Rent> listRent;

	public RentDAO()
	{
		listRent = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		String txt = "";

		for (Rent rent : listRent)
		{
			txt += rent.toString();
		}

		return txt;
	}

	public Rent findRent(int id)
	{
		Rent rent = null;
		boolean b = false;

		for (int i = 0; i < listRent.size() && !b; i++)
		{
			if (id == listRent.get(i).getId())
			{
				rent = listRent.get(i);
				b = true;
			}
		}
		return rent;
	}

	public void addRent(Rent al)
	{
		listRent.add(al);
	}

	public void eraseRent(int id)
	{
		Rent rent = findRent(id);

		if (rent != null)
		{
			listRent.remove(rent);
		}
		else
		{
			throw new RuntimeException("Rent Not Found");
		}
	}
}