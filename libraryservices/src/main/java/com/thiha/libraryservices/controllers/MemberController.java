package com.thiha.libraryservices.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiha.libraryservices.entities.Member;
import com.thiha.libraryservices.services.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public Iterable<Member> getAllTownship(){
		return memberService.listAllMember();
	}
	
	@RequestMapping(value = "/members/{id}", method = RequestMethod.GET)
	public Member getTownship(@PathVariable String id){
		return memberService.getMemberById(id);
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Member createNewMember(@RequestBody Member member) {
		if(memberService.isMemberExist(member)){
			logger.error("Unable to create. A Member with name {} already exist", member.getName());
            return null;
		}
		UUID id = UUID.randomUUID();
		member.setId(id.toString());
		logger.info(id.toString());
		return memberService.saveMember(member);
	}
	
	@RequestMapping(value = "/members/{id}", method = RequestMethod.PUT)
	public Member updateMember(@PathVariable String id, @RequestBody Member member) {
		Member updateMember = memberService.getMemberById(id);
		updateMember.setName(member.getName());
		updateMember.setSex(member.getSex());
		updateMember.setDob(member.getDob());
		updateMember.setAddress(member.getAddress());
		updateMember.setPhone(member.getPhone());
		updateMember.setEmail(member.getEmail());
		updateMember.setEducation(member.getEducation());
		return memberService.saveMember(updateMember);
	}
	
	@RequestMapping(value = "/members/{id}", method = RequestMethod.DELETE)
	public void deleteMember(@PathVariable String id) {
		memberService.deleteMember(id);
	}
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting(){
		UUID id = UUID.randomUUID();
		logger.info(id.toString());
		logger.info("Hello!");
		return "Hello!";
	}
}
