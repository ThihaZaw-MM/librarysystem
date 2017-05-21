package com.thiha.libraryservices.services;

import com.thiha.libraryservices.entities.Member;

public interface MemberService {
	Iterable<Member> listAllMember();
	Member getMemberById(String id);
	Member saveMember(Member member);
	void deleteMember(String id);
	boolean isMemberExist(Member member);
}
