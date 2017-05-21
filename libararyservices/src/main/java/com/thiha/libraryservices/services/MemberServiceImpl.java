package com.thiha.libraryservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiha.libraryservices.entities.Member;
import com.thiha.libraryservices.repositories.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberRepository memberRepository;
	
	@Autowired
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public Iterable<Member> listAllMember() {
		return memberRepository.findAll();
	}

	@Override
	public Member getMemberById(String id) {
		return memberRepository.findOne(id);
	}

	@Override
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public void deleteMember(String id) {
		memberRepository.delete(id);
	}

	@Override
	public boolean isMemberExist(Member member) {
		return memberRepository.exists(member.getId());
	}

}
