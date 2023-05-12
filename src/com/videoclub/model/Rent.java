package com.videoclub.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rent
{
	private static int idCounter = 0;
	private int id;
	private Member member;
	private final ArrayList<Multimedia> listMultimedia;
	private double debt;
	private LocalDate rentDate;

	public Rent()
	{
		setId(idCounter++);
		setMember(new Member());
		setDebt(calculateDebt());
		rentDate = LocalDate.now();
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
			else if (multimedia instanceof Videogame)
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

	public double getDebt()
	{
		return debt;
	}

	public void setDebt(double debt)
	{
		this.debt = debt;
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

	public double calculateDebt()
	{
		return 0.0;
	}

	public boolean hasDebt()
	{
		return debt > 0;
	}
}