package com.videoclub.model;

import java.util.ArrayList;

public class RentManager
{
	private ArrayList<Rent> listMultimedia;

	public RentManager()
	{
		listMultimedia = new ArrayList<>();
	}

	public void addRent(Rent al)
	{
		listMultimedia.add(al);
	}

	@Override
	public String toString()
	{
		StringBuilder text = new StringBuilder();

		for (Rent alquiler : listMultimedia)
		{
			text.append(alquiler.toString());
		}

		return text.toString();
	}

	public boolean hasDebt(String nif)
	{
		boolean nani = false;
		for (Rent rent : listMultimedia)
		{
			if (rent.getMember().getNif().equals(nif))
			{
				nani = true;
				break;
			}
		}
		return nani;
	}

	public ArrayList<Rent> getListMultimedia()
	{
		return listMultimedia;
	}

	public void setListMultimedia(ArrayList<Rent> listMultimedia)
	{
		this.listMultimedia = listMultimedia;
	}

	public void printMemberRent(Member socio)
	{
		for (Rent alquiler : listMultimedia)
		{
			if (alquiler.getMember().equals(socio))
			{
				//System.out.println(alquiler.toString());
				System.out.println(socio.toString());

				//System.out.println(alquiler.getArrayListMultimedia());
			}
		}
	}

	public ArrayList<String> getListMemberRent(String nif)
	{
		ArrayList<String> listAlquileresSocio = new ArrayList<>();

		for (Rent alquiler : listMultimedia)
		{
			if (alquiler.getMember().getNif().equals(nif))
			{
				for (Multimedia multimedia : alquiler.getArrayListMultimedia())
				{
					listAlquileresSocio.add(multimedia.getTitle());
				}
			}
		}
		return listAlquileresSocio;
	}

	public ArrayList<String> getListMemberRecharge()
	{
		ArrayList<String> listSocioRecargo = new ArrayList<>();

		for (Rent alquiler : listMultimedia)
		{
			if (alquiler.hasDebt())
			{
				listSocioRecargo.add(alquiler.getMember().toString());
			}
		}
		return listSocioRecargo;
	}
}