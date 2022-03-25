package com.project2springbootrestspringdataers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2springbootrestspringdataers.dao.EmployeeRepository;
import com.project2springbootrestspringdataers.entity.EmployeeEntity;
import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.EmployeePojo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeServiceImpl() {
		//employeeDao = new EmployeeJdbcDaoImpl();
	}
	
	// fetch an employee
	
	@Override
	public EmployeePojo employeeViewDetails(int employeeId) throws SystemException {
		Optional<EmployeeEntity> entity= employeeRepository.findById(employeeId);
		EmployeePojo employeePojo = null;
		if(entity.isPresent()) {
			EmployeeEntity employeeEntity= entity.get();
			employeePojo= new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeePassword(),
					employeeEntity.getEmployeeFirstName(),employeeEntity.getEmployeeLastName(),
					employeeEntity.getEmployeeContact(), employeeEntity.getEmployeeAddress(),
					employeeEntity.getEmployeeImageUrl());
		}
		return employeePojo;
	}
	
	// fetch an employee
//	@Override
//	public EmployeePojo employeeViewDetails(int employeeId) throws SystemException {
//		EmployeeEntity entity= employeeRepository.getByEmployeeId(employeeId);
//		EmployeePojo employeePojo = new EmployeePojo();
//		BeanUtils.copyProperties(entity, employeePojo);
//		return employeePojo;
//	}
	
	
	//Login employee
	@Override
	public EmployeePojo loginEmployee(String employeeContact, String employeePassword) throws SystemException {
		EmployeeEntity employeeEntity = employeeRepository.findByEmployeeContactAndEmployeePassword(employeeContact, employeePassword);
		EmployeePojo employeePojo = null;
		if(employeeEntity!=null) {
			employeePojo = new EmployeePojo();
			BeanUtils.copyProperties(employeeEntity, employeePojo);
		}
		return employeePojo;
	}

	// update employee info
	@Override
	public EmployeePojo updateEmployeeInfo(EmployeePojo employeePojo) throws SystemException {
		EmployeeEntity employeeEntity = new EmployeeEntity(employeePojo.getEmployeeId(),
				employeePojo.getEmployeePassword(),employeePojo.getEmployeeFirstName(),
				employeePojo.getEmployeeLastName(),employeePojo.getEmployeeContact(), 
				employeePojo.getEmployeeAddress(),employeePojo.getEmployeeImageUrl());
		employeeRepository.save(employeeEntity);
		employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(),employeeEntity.getEmployeePassword(),
				employeeEntity.getEmployeeFirstName(),employeeEntity.getEmployeeLastName(),
				employeeEntity.getEmployeeContact(), employeeEntity.getEmployeeAddress(),
				employeeEntity.getEmployeeImageUrl());
		
		return employeePojo;
	}

	//fetch all employee
	@Override
	public List<EmployeePojo> fetchAllEmployees() throws SystemException {
		List<EmployeeEntity> entityList = employeeRepository.findAll();
		List<EmployeePojo>	pojoList = new ArrayList<>(); // blank list
		for(EmployeeEntity entity : entityList) {
			
			EmployeePojo pojo = new EmployeePojo(); // blank object
			BeanUtils.copyProperties(entity, pojo);
			pojoList.add(pojo);
		}
		return pojoList;
	}
	

	

	

}
