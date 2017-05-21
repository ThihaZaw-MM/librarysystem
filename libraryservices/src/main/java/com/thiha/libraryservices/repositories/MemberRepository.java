package com.thiha.libraryservices.repositories;

import org.springframework.data.repository.CrudRepository;

import com.thiha.libraryservices.entities.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
	
}
