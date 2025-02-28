package com.DevSprint.LibraryMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DevSprint.LibraryMS.entities.LendingEntity;

@Repository
public interface LendingRepository extends JpaRepository<LendingEntity, String>{
}
