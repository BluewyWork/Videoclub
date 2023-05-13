package com.videoclub.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rent
{
	private static int idCounter = 0;
	private int id;
	private Member member;
	private final ArrayList<Multimedia> listMultimedia;
	private double initialDebt;
	private double finalDebt;
	private LocalDate rentDate;
	private final LocalDate returnDate;

	public Rent()
	{
		setId(idCounter++);
		setMember(new Member());
		setInitialDebt(calculateInitialDebt());
		rentDate = LocalDate.now();
		returnDate = LocalDate.now().plusDays(Constants.RENT_MAX_DURATION);
		listMultimedia = new ArrayList<>();
	}

	public Rent(Member member)
	{
		this();
		setMember(member);
	}

	@Override
	public String toString()
	{
		StringBuilder text = new StringBuilder();

		text.append(member.toString()).append("\n");

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

	public Member getMember()
	{
		return member;
	}

	public void setMember(Member member)
	{
		this.member = member;
	}

	public ArrayList<Multimedia> getArrayListMultimedia()
	{
		return listMultimedia;
	}

	public void setListMultimedia(Multimedia listMultimedia)
	{
		this.listMultimedia.add(listMultimedia);
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