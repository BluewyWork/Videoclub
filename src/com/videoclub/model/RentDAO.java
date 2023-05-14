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
		StringBuilder txt = new StringBuilder();

		for (Rent rent : listRent)
		{
			txt.append(rent.toString()).append("\n");
		}

		return txt.toString();
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

		if (rent == null)
		{
			throw new RuntimeException("Rent Object with ID: " + id + " not found");
		}

		return rent;
	}

	public ArrayList<Rent> findRent(String memberNIF)
	{
		ArrayList<Rent> listRent = new ArrayList<>();

		for (Rent rent : this.listRent)
		{
			if (rent.getMemberNIF().equals(memberNIF))
			{
				listRent.add(rent);
			}
		}

		return listRent;
	}

	public void addRent(Rent al)
	{
		listRent.add(al);
	}

	public void eraseRent(int id)
	{
		Rent rent = findRent(id);

		if (!listRent.remove(rent))
		{
			throw new RuntimeException("Rent with ID: " + id + " not found");
		}
	}

	public boolean checkPendingPayments(String memberNIF)
	{
		boolean pendingPayments = false;

		ArrayList<Rent> listRent = findRent(memberNIF);

		for (Rent rent : listRent)
		{
			pendingPayments = rent.isOverdue();
		}

		return pendingPayments;
	}
}