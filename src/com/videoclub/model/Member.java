package com.videoclub.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Member
{
	private String nif;
	private String name;
	private LocalDate birthDate;
	private String town;

	public Member()
	{
		nif = "RANDOM";
		name = "RANDOM";
		birthDate = LocalDate.of(2003, 1, 1);
		town = "RANDOM";
	}

	public Member(String nif, String name, LocalDate birthDate, String town)
	{
		this.nif = nif;
		this.name = name;
		setBirthDate(birthDate);
		this.town = town;
	}

	public Member(String nif, String name, String birthDate, String town)
	{
		this();
		this.nif = nif;
		this.name = name;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		this.birthDate = LocalDate.parse(birthDate, formatter);
		this.town = town;
	}

	@Override
	public String toString()
	{
		return
				"Socio: " + "\n" +
						"\t" + "Nif: " + nif + "\n" +
						"\t" + "Nombre: " + name + "\n" +
						"\t" + "FechaNac: " + birthDate + "\n" +
						"\t" + "Poblacion: " + town;
	}

	public String getNif()
	{
		return nif;
	}

	public void setNif(String nif)
	{
		this.nif = nif;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public LocalDate getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate)
	{
		if (isAdult())
		{
			this.birthDate = birthDate;
		}
		else
		{
			throw new RuntimeException("Member must be an ADULT (+18)");
		}

	}

	public String getTown()
	{
		return town;
	}

	public void setTown(String town)
	{
		this.town = town;
	}

	public boolean isAdult()
	{
		Period myPeriod = Period.between(birthDate, LocalDate.now());

		return myPeriod.getYears() >= 18;
	}
}