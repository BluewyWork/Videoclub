package com.videoclub.model;

import java.util.ArrayList;

public class MemberDAO
{
	private final ArrayList<Member> listMembers;

	public MemberDAO()
	{
		listMembers = new ArrayList<>();
	}

	public Member findMember(String nif)
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

	public void addMember(Member member)
	{
		listMembers.add(member);
	}

	public void removeMember(String nif)
	{
		Member member = findMember(nif);
		if (member != null)
		{
			listMembers.remove(findMember(nif));
		}
		else
		{
			throw new RuntimeException("Member with " + nif + " not found!");
		}

	}

	public boolean containsMember(String nif)
	{
		return findMember(nif) != null;
	}
}