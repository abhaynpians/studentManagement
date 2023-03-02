package com.abhay.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhay.studentManagement.entities.CollegeStudent;

public interface CollegeStudentRepository extends JpaRepository<CollegeStudent, Integer> {

	
}
