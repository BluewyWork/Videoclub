package com.videoclub.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rent
{
	private static int idCounter = 0;
	private int id;
	private Member member;
	private ArrayList<Multimedia> arrMultimedia;
	private double debt;
	private LocalDate rentDate;

	public Rent()
	{
		setId(idCounter++);
		setMember(new Member());
		setDebt(calcularDeuda());
		rentDate = LocalDate.now();
		arrMultimedia = new ArrayList<>();
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

		for (Multimedia multimedia : arrMultimedia)
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
		return arrMultimedia;
	}

	public void setArrMultimedia(Multimedia multimediaAlquilada)
	{
		this.arrMultimedia.add(multimediaAlquilada);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public double calcularDeuda()
	{
		return 0.0;
	}

	public boolean tieneDeuda()
	{
		return debt > 0;
	}
}