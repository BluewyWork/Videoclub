package com.videoclub.controller;

import com.videoclub.model.Multimedia;
import com.videoclub.model.Rent;
import com.videoclub.model.RentDAO;

public class RentController
{
	private RentDAO rentDAO;

	public RentController()
	{
		rentDAO = new RentDAO();
	}

	public void rentMultimedia(String memberNIF, Multimedia multimedia)
	{
		Rent rent = new Rent(memberNIF, multimedia);

		rentDAO.addRent(rent);
	}

	public Rent returnRent(int id)
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
