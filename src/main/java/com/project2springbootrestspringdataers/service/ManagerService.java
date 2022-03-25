package com.project2springbootrestspringdataers.service;

import java.util.List;

import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.EmployeePojo;
import com.project2springbootrestspringdataers.pojo.ManagerPojo;


public interface ManagerService {

//	  //fetch a manager
//		ManagerPojo fetchOneManager(String employeeContact)throws SystemException;

		// login manager		
		ManagerPojo loginManager(String managerContact, String managerPassword)throws SystemException;
		ManagerPojo managerViewinfo(String managerContact)throws SystemException;
		//View all employees
		List<ManagerPojo> fetchAllManagers()throws SystemException;
	 
//		// add/delete in two Reimbursement table
//		MergedReimbursmentPojo approveOrDeny(MergedReimbursmentPojo resolvedReimbursmentPojo)throws SystemException;
//		
//		//Fetch/read a pending request
//		MergedReimbursmentPojo fetchAPendingRequest(int reimbursementId) throws SystemException;
////		imp� View all pending requests of all employees. 
//		List<MergedReimbursmentPojo> fetchAllPendingReq()throws SystemException;
////		imp� View all resolved requests of all employees.
//		 List<MergedReimbursmentPojo> fetchAllResolveReq()throws SystemException;
//		
//		//� View reimbursement requests of a specific employee.
//		 List<MergedReimbursmentPojo> viewReimbursementReq(int requestingEmployeeId)throws SystemException;
//		
//		//read
//			List<EmployeePojo> fetchAllEmployee()throws SystemException;
//	
//	
//


}
