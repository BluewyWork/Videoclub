package com.videoclub.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rent
{
	private static int idCounter = 0;
	private int id;
	private String memberNIF;
	private ArrayList<Multimedia> listMultimedia;
	private double initialDebt;
	private double finalDebt;
	private LocalDate rentDate;
	private final LocalDate returnDate;

	public Rent()
	{
		listMultimedia = new ArrayList<>();
		setId(idCounter++);
		memberNIF = "RANDOM";
		setInitialDebt(calculateInitialDebt());
		rentDate = LocalDate.now();
		returnDate = LocalDate.now().plusDays(Constants.RENT_MAX_DURATION);

	}

	public Rent(String memberNIF, Multimedia multimedia)
	{
		this();
		setMemberNIF(memberNIF);
		listMultimedia.add(multimedia);
	}

	public Rent(String memberNIF, ArrayList<Multimedia> listMultimedia)
	{
		this();
		setMemberNIF(memberNIF);
		setListMultimedia(listMultimedia);
	}

	@Override
	public String toString()
	{
		StringBuilder text = new StringBuilder();

		text.append(memberNIF).append("\n");

		for (Multimedia multimedia : listMultimedia)
		{
			if (multimedia instanceof Movie)
			{
				text.append(multimedia.toString()).append("\n");
			}
			else if (multimedia instanceof VideoGame)
			{
				text.append(multimedia.toString()).append("\n");
			}
			else if (multimedia instanceof Disc)
			{
				text.append(multimedia.toString()).append("\n");
			}
			else
				text.append("ERROR");
		}

		return text.toString();
	}

	public LocalDate getRentDate()
	{
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate)
	{
		this.rentDate = rentDate;
	}

	public double getInitialDebt()
	{
		return initialDebt;
	}

	public void setInitialDebt(double initialDebt)
	{
		this.initialDebt = initialDebt;
	}

	public String getMemberNIF()
	{
		return memberNIF;
	}

	public void setMemberNIF(String memberNIF)
	{
		this.memberNIF = memberNIF;
	}

	public ArrayList<Multimedia> getArrayListMultimedia()
	{
		return listMultimedia;
	}

	public void setListMultimedia(ArrayList<Multimedia> listMultimedia)
	{
		this.listMultimedia = listMultimedia;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public boolean isOverdue()
	{
		return daysOverdue() > 0;
	}

	public int daysOverdue()
	{
		return returnDate.until(LocalDate.now()).getDays();
	}

	public double calculateInitialDebt()
	{
		double debt = 0;

		for (Multimedia multimedia : listMultimedia)
		{
			debt += multimedia.calculateRentPrice();
		}

		return debt;
	}

	public double calculateFinalDebt()
	{
		double debt = 0;

		if (isOverdue())
		{
			debt += daysOverdue() * Constants.SURCHARGE_PER_DAY * listMultimedia.size();
		}

		return debt + initialDebt;
	}
}