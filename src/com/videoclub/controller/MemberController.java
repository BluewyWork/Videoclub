package com.videoclub.controller;

import com.videoclub.lib.Input;
import com.videoclub.model.Member;
import com.videoclub.model.MemberDAO;

public class MemberController
{
	private final MemberDAO memberDAO;

	public MemberController()
	{
		memberDAO = new MemberDAO();
	}

	public void registerMember(String nif, String name, String birthDate, String town)
	{
		Member member = new Member(nif ,name, birthDate, town);

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
