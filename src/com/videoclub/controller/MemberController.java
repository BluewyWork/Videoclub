package com.videoclub.controller;

import com.videoclub.lib.Input;
import com.videoclub.model.*;

import java.net.Socket;

public class MemberController
{
	private final MemberDAO memberDAO;

	public MemberController()
	{
		memberDAO = new MemberDAO();
	}

	public void registerMember()
	{
		String nif = Input.readInput("NIF: ", "String");
		String name = Input.readInput("Name: ", "String");
		String birthDate = Input.readInput("Birth Date (dd/mm/yyyy): ");
		String town = Input.readInput("Town: ", "String");

		Member member = new Member(nif, name, birthDate, town);

		memberDAO.addMember(member);
	}

	public void unregisterMember(String nif)
	{
		memberDAO.removeMember(nif);
	}

	public String showMembers()
	{
		return memberDAO.toString();
	}
}
