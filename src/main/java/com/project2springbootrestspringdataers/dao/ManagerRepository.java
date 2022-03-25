package com.project2springbootrestspringdataers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2springbootrestspringdataers.entity.EmployeeEntity;
import com.project2springbootrestspringdataers.entity.ManagerEntity;


@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity,Integer>{
	
	//Login manager findByMangerContactAndManagerPassword
	ManagerEntity findByManagerContactAndManagerPassword(String managerContact, String managerPassword);
	
	//
	ManagerEntity findByManagerContact(String managerContact);
	
}
