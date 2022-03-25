package com.project2springbootrestspringdataers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;


import com.project2springbootrestspringdataers.dao.EmployeeRepository;
import com.project2springbootrestspringdataers.dao.ManagerRepository;
import com.project2springbootrestspringdataers.dao.PendingReimbursmentRepository;
import com.project2springbootrestspringdataers.entity.EmployeeEntity;
import com.project2springbootrestspringdataers.entity.ManagerEntity;
import com.project2springbootrestspringdataers.entity.PendingReimbursmentEntity;
import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.EmployeePojo;
import com.project2springbootrestspringdataers.pojo.ManagerPojo;
import com.project2springbootrestspringdataers.pojo.PendingReimbursmentPojo;
import com.project2springbootrestspringdataers.service.EmployeeServiceImpl;

import com.project2springbootrestspringdataers.service.ManagerServiceImpl;
import com.project2springbootrestspringdataers.service.PendingReimbursmentServiceImpl;
import com.project2springbootrestspringdataers.exception.SystemException;
@SpringBootTest
class Project2SpringBootRestSpringdataErsApplicationTests {
	
	@InjectMocks
	EmployeeServiceImpl employeeService;
	
	@Mock
	EmployeeRepository employeeRepository;	
	
	@InjectMocks
	ManagerServiceImpl managerService;
	@Mock
	ManagerRepository managerRepository;
	
	@InjectMocks
	PendingReimbursmentServiceImpl pendingReimbursmentService;
	@Mock
	PendingReimbursmentRepository pendingReimbursmentRepository;
	
	@Test
	void testFetchEmployee() throws SystemException{
		try {
			when(employeeRepository.findById(1)).thenReturn(Optional.of(new EmployeeEntity(1,"root","Samia", "Jahan",  "samia@gmail.com" , "D drive","")));
			EmployeePojo actualResult;
			actualResult = employeeService.employeeViewDetails(1);
			EmployeePojo expectedResult = new EmployeePojo(1,"root","Samia", "Jahan",  "samia@gmail.com" , "D drive","");
			
			assertEquals(actualResult,expectedResult);
			verify(employeeRepository).findById(1);
		} catch (SystemException e) {
			
			throw new SystemException();
		}
				
	}
	@Test
	void loginEmployee() throws SystemException{
	try {
		when(employeeRepository.findByEmployeeContactAndEmployeePassword("samia@gmail.com", "root")).thenReturn(new EmployeeEntity(1,"root","Samia", "Jahan",  "samia@gmail.com" , "D drive",""));
	EmployeePojo actualResult = employeeService.loginEmployee("samia@gmail.com", "root");
	EmployeePojo expectedResult = new EmployeePojo(1,"root","Samia", "Jahan",  "samia@gmail.com" , "D drive","");
	
	assertEquals(actualResult,expectedResult);
	verify(employeeRepository).findById(1);
	}catch (SystemException e) {
		
		throw new SystemException();
	}
	

	}
	
//	@Test
//	@Rollback(false)
//	void updateEmployeeInfo() {
//		try {//if does not work then change it to pojo
//			EmployeePojo employeePojo = new EmployeePojo(1,"root","Samia", "Jahan",  "samia@gmail.com" , "D drive","");
////			when(employeeRepository.save(employeePojo).thenReturn(employeePojo));
////			EmployeePojo expectedResult = employeeService.updateEmployeeInfo(employeePojo);
////			assertE
//			employeePojo.setEmployeeAddress("hh drive");
//			employeeRepository.save(employeePojo);
//			EmployeeEntity updateEmployeePojo = employeeRepository.findByEmployeeContactAndEmployeePassword("samia@gmail.com", "root");
//			assertEquals(updateEmployeePojo.getEmployeeAddress()).isEqualTo("hh drive");
//		}catch (SystemException e) {
//			e.printStackTrace();
//		} 
//	}
	
	
//	
 @Test
  void fetchAllEmployees() throws SystemException{
	 try {
		 List<EmployeeEntity>	actualResult = new ArrayList<>(); 
		 actualResult.add(new EmployeeEntity(1,"root","Samia", "Jahan",  "samia@gmail.com" , "D drive",""));
		 actualResult.add(new EmployeeEntity(2,"root","Shabaz", "Jahan",  "shabaj@gmail.com" , "D drive",""));
		 when(employeeRepository.findAll()).thenReturn(actualResult);
		 List<EmployeePojo>	expectedResult = employeeService.fetchAllEmployees();
		 assertEquals(actualResult,expectedResult);
	 }catch (SystemException e) {
			
			throw new SystemException();
		}

	}

//-------------------Manager-------------------

@Test
void managerViewinfo()throws SystemException {
	try {
		when(managerRepository.findByManagerContact("Poonga@gmail.com")).thenReturn(new ManagerEntity(1,"root","Poonga", "Anand","Poonga@gmail.com" ,"F drive lane",""));
		ManagerPojo actualResult;
		actualResult = managerService.managerViewinfo("Poonga@gmail.com");
		ManagerPojo expectedResult = new ManagerPojo(1,"root","Poonga", "Anand","Poonga@gmail.com" ,"F drive lane","");
		
		assertEquals(actualResult,expectedResult);
		verify(managerRepository).findByManagerContact("Poonga@gmail.com");
	} catch (SystemException e) {
		
		throw new SystemException();
	}
			
}
@Test
void loginManager() throws SystemException{
try {
	when(managerRepository.findByManagerContactAndManagerPassword("Poonga@gmail.com", "root")).thenReturn(new ManagerEntity(1,"root","Poonga", "Anand","Poonga@gmail.com" ,"F drive lane",""));
	ManagerPojo actualResult = managerService.loginManager("Poonga@gmail.com", "root");
	ManagerPojo expectedResult = new ManagerPojo(1,"root","Poonga", "Anand","Poonga@gmail.com" ,"F drive lane","");

assertEquals(actualResult,expectedResult);
verify(employeeRepository).findById(1);
}catch (SystemException e) {
	
	throw new SystemException();
}
}

@Test
void fetchAllManagers()throws SystemException {
	 try {
		 List<ManagerEntity>	actualResult = new ArrayList<>(); 
		 actualResult.add(new ManagerEntity(1,"root","Poonga", "Anand","Poonga@gmail.com" ,"F drive lane",""));
		 actualResult.add(new ManagerEntity(2,"root","Jack", "Miler",  "jack@gmail.com" , "hh high lane",""));
		 when(managerRepository.findAll()).thenReturn(actualResult);
		 List<ManagerPojo>	expectedResult = managerService.fetchAllManagers();
		 assertEquals(actualResult,expectedResult);
	 }catch (SystemException e) {
			
			throw new SystemException();
		}

	}
}
//-----------------------Reimbursement------------
	
//@Test
//void viewReimbursementPendingReq() throws SystemException{
//	try {
//		when(pendingReimbursmentRepository.findById(1)).thenReturn(Optional.of(new PendingReimbursmentEntity(1,1,500.55,"2022-03-07")));
//		PendingReimbursmentPojo actualResult;
//		actualResult = pendingReimbursmentService.viewReimbursementPendingReq(1);
//		PendingReimbursmentPojo expectedResult = new PendingReimbursmentPojo(1,1,500.55, "2022-03-07");
//		
//		assertEquals(actualResult,expectedResult);
//		verify(pendingReimbursmentRepository).findById(1);
//	} catch (SystemException e) {

//throw new SystemException();
//}
			
//}