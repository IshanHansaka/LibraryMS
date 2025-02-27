package com.DevSprint.LibraryMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DevSprint.LibraryMS.entities.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String>{
}
