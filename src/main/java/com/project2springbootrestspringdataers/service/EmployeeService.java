package com.project2springbootrestspringdataers.service;

import java.util.List;

import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.EmployeePojo;

//@Component
public interface EmployeeService {
	//EmployeePojo employeeInfo(int employeeId) throws SystemException;
	
	//View their information. ------fetchAnEmployee
	EmployeePojo employeeViewDetails(int employeeId)throws SystemException;
	//	Login. 
	//EmployeePojo login(String employeeContact, String employeePassword)throws SystemException;	

	//Update their information.-----update 
	EmployeePojo updateEmployeeInfo(EmployeePojo employeePojo)throws SystemException;
	
	//View all employees
	List<EmployeePojo> fetchAllEmployees()throws SystemException;

	EmployeePojo loginEmployee(String employeeContact, String employeePassword) throws SystemException;
	

}
