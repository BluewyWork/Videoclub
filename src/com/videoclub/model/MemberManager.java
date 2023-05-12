package com.videoclub.model;

import java.util.ArrayList;

public class MemberManager
{
	private final ArrayList<Member> listMembers;

	public MemberManager()
	{
		listMembers = new ArrayList<>();
	}

	public void addMember(String nif, String name, String birthDate, String town)
	{
		listMembers.add(new Member(nif, name, birthDate, town));
	}

	public boolean containsMember(String nif)
	{
		boolean b = false;
		for (int i = 0; i < listMembers.size() && !b; i++)
		{
			if (nif.equals(listMembers.get(i).getNif()))
			{
				System.out.println("NIF" + listMembers.get(i).getNif());
				b = true;
			}
		}
		return b;
	}

	public Member getMember(String nif)
	{
		Member member = null;
		boolean b = false;

		for (int i = 0; i < listMembers.size() && !b; i++)
		{
			if (nif.equals(listMembers.get(i).getNif()))
			{
				member = listMembers.get(i);
				b = true;
			}
		}
		return member;
	}
}