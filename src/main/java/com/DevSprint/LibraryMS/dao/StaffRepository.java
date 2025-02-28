package com.DevSprint.LibraryMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DevSprint.LibraryMS.entities.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, String>{    
}
