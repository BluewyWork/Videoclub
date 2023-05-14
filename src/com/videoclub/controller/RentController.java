package com.videoclub.controller;

import com.videoclub.model.Multimedia;
import com.videoclub.model.Rent;
import com.videoclub.model.RentDAO;

import java.util.ArrayList;

public class RentController
{
	private RentDAO rentDAO;

	public RentController()
	{
		rentDAO = new RentDAO();
	}

	// using clever techniques to retrieve desired amount of
	// multimedia and pass it as an argument
	public void rentMultimedias(String memberNIF, ArrayList<Multimedia> listMultimedia)
	{
		if (rentDAO.checkPendingPayments(memberNIF))
		{
			Rent rent = new Rent(memberNIF, listMultimedia);
			rentDAO.addRent(rent);
		}
		else
		{
			throw new RuntimeException("Member with NIF: " + memberNIF + " has pending payments");
		}
	}

	public Rent releaseRent(int id)
	{
		Rent rent = rentDAO.findRent(id);

		rentDAO.eraseRent(id);

		return rent;
	}

	public String showRents()
	{
		return rentDAO.toString();
	}
}
