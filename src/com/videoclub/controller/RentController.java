package com.videoclub.controller;

import com.videoclub.model.*;

public class RentController
{
	private RentDAO rentDAO;

	public RentController()
	{
		rentDAO = new RentDAO();
	}

	public void rentMultimedia(Member member, Multimedia multimedia)
	{
		Rent rent = new Rent(member, multimedia);

		rentDAO.addRent(rent);
	}
}
