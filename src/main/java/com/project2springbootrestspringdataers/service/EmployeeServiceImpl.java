package com.project2springbootrestspringdataers.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public static final Logger LOG = LogManager.getLogger(EmployeeServiceImpl.class);
	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeServiceImpl() {
		//employeeDao = new EmployeeJdbcDaoImpl();
	}
	
	// fetch an employee
	
	@Override
	public EmployeePojo employeeViewDetails(int employeeId) throws SystemException {
		LOG.info("Entered employeeViewDetails() in Service");

		Optional<EmployeeEntity> entity= employeeRepository.findById(employeeId);
		EmployeePojo employeePojo = null;
		if(entity.isPresent()) {
			EmployeeEntity employeeEntity= entity.get();
			employeePojo= new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeePassword(),
					employeeEntity.getEmployeeFirstName(),employeeEntity.getEmployeeLastName(),
					employeeEntity.getEmployeeContact(), employeeEntity.getEmployeeAddress(),
					employeeEntity.getEmployeeImageUrl());
		}
		LOG.info("Exited employeeViewDetails() in Service");
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
		LOG.info("Entered loginEmployee() in Service");
		EmployeeEntity employeeEntity = employeeRepository.findByEmployeeContactAndEmployeePassword(employeeContact, employeePassword);
		EmployeePojo employeePojo = null;
		if(employeeEntity!=null) {
			employeePojo = new EmployeePojo();
			BeanUtils.copyProperties(employeeEntity, employeePojo);
		}
		LOG.info("Exited loginEmployee() in Service");
		return employeePojo;
	}

	// update employee info
	@Override
	public EmployeePojo updateEmployeeInfo(EmployeePojo employeePojo) throws SystemException {
		LOG.info("Entered updateEmployeeInfo() in Service");
		EmployeeEntity employeeEntity = new EmployeeEntity(employeePojo.getEmployeeId(),
				employeePojo.getEmployeePassword(),employeePojo.getEmployeeFirstName(),
				employeePojo.getEmployeeLastName(),employeePojo.getEmployeeContact(), 
				employeePojo.getEmployeeAddress(),employeePojo.getEmployeeImageUrl());
		employeeRepository.save(employeeEntity);
		employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(),employeeEntity.getEmployeePassword(),
				employeeEntity.getEmployeeFirstName(),employeeEntity.getEmployeeLastName(),
				employeeEntity.getEmployeeContact(), employeeEntity.getEmployeeAddress(),
				employeeEntity.getEmployeeImageUrl());
		LOG.info("Exited updateEmployeeInfo() in Service");
		return employeePojo;
	}

	//fetch all employee
	@Override
	public List<EmployeePojo> fetchAllEmployees() throws SystemException {
		LOG.info("Entered fetchAllEmployees() in Service");
		List<EmployeeEntity> entityList = employeeRepository.findAll();
		List<EmployeePojo>	pojoList = new ArrayList<>(); // blank list
		for(EmployeeEntity entity : entityList) {
			
			EmployeePojo pojo = new EmployeePojo(); // blank object
			BeanUtils.copyProperties(entity, pojo);
			pojoList.add(pojo);
		}
		LOG.info("Exited fetchAllEmployees() in Service");
		return pojoList;
	}
	

	

	

}
