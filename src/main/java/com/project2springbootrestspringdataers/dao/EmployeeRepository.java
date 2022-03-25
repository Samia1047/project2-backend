package com.project2springbootrestspringdataers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2springbootrestspringdataers.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	
	//List<EmployeeEntity> findByIdEmployeeId(int employeeId);
	
	//Login employee findByContactAndPassword
	EmployeeEntity findByEmployeeContactAndEmployeePassword(String employeeContact, String employeePassword);
	
	//update employee use getByEmployee
	EmployeeEntity getByEmployeeId(int employeeId);
 
	

}
