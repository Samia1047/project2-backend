package com.project2springbootrestspringdataers.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.EmployeePojo;
import com.project2springbootrestspringdataers.pojo.ErsProofImagePojo;
import com.project2springbootrestspringdataers.pojo.ManagerPojo;
import com.project2springbootrestspringdataers.pojo.PendingReimbursmentPojo;
import com.project2springbootrestspringdataers.pojo.ResolvedReimbursmentPojo;
import com.project2springbootrestspringdataers.service.EmployeeService;
import com.project2springbootrestspringdataers.service.ErsProofImageImageService;
import com.project2springbootrestspringdataers.service.ManagerService;
import com.project2springbootrestspringdataers.service.PendingReimbursmentService;
import com.project2springbootrestspringdataers.service.ResolvedReimbursmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4444", "http://localhost:4200"})
public class ErsMainCortroller {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	PendingReimbursmentService pendingReimbursmentService;
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	ResolvedReimbursmentService resolvedReimbursmentService;
	
	//proofImage
	@Autowired
	ErsProofImageImageService ersProofImageImageService;
	
	//read or view an employee details
	//http://localhost:4444/api/employees/1
	@GetMapping("employees/{employeeId}")
	public EmployeePojo employeeViewDetails(@PathVariable("employeeId") int empId)throws SystemException {
		
		return employeeService.employeeViewDetails(empId);
	}
	
	//============================EMPLOYEE================================
	
	//update
	//http://localhost:4444/api/employees/employee-update
	@PutMapping("employees/employee-update")
	public EmployeePojo updateEmployeeInfo(@RequestBody EmployeePojo employeePojo) throws SystemException {
		
		return employeeService.updateEmployeeInfo(employeePojo);
	}
	
		//Login employee
		//http://localhost:4444/api/employees/login/Haile@gmail.com/root
		@GetMapping("employees/login/{employeeContact}/{employeePassword}")
		public EmployeePojo loginEmployee(@PathVariable("employeeContact") String employeeContact,@PathVariable("employeePassword") String employeePassword ) throws SystemException {
			
			return employeeService.loginEmployee(employeeContact, employeePassword);
		}

	
	// view all employees
	// http://localhost:4444/api/employees
	@GetMapping("employees")
	public List<EmployeePojo> fetchAllEmployees() throws SystemException {
		return employeeService.fetchAllEmployees();
	}
	
	// Submit a reimbursement request
	// http://localhost:4444/api/all-pending/submit-request
	@PostMapping("all-pending/submit-request")
	public PendingReimbursmentPojo submitReimbursementReq(@RequestBody PendingReimbursmentPojo pendingReimbursementPojo) throws SystemException {
		return pendingReimbursmentService.submitReimbursementReq(pendingReimbursementPojo);
		
	}
	// View Reimbusrsment pending request
	//http://localhost:4444/api/all-pending/7
	@GetMapping("all-pending/{reimbursementId}")
	public PendingReimbursmentPojo viewReimbursementPendingReq(@PathVariable("reimbursementId") int reimbursementId) throws SystemException {
		return pendingReimbursmentService.viewReimbursementPendingReq(reimbursementId);
	}

		
	
	//============================MANAGER================================
	
	// fetch mananger
		@GetMapping("manager")
		public List<ManagerPojo> fetchAllManagers() throws SystemException {
			return managerService.fetchAllManagers();
		}
		
		// login mananger
		//http://localhost:4444/api/manager/login/Poonga@gmail.com/root
	@GetMapping("manager/login/{managerContact}/{managerPassword}")
	public ManagerPojo loginManager(@PathVariable("managerContact") String managerContact, @PathVariable("managerPassword")String managerPassword) throws SystemException {
		return managerService.loginManager(managerContact, managerPassword);
	}
	
	// View manager info
	//http://localhost:4444/api/manager/Poonga@gmail.com
	@GetMapping("manager/{managerContact}")
	public ManagerPojo managerViewinfo(@PathVariable("managerContact") String managerContact) throws SystemException {
		return managerService.managerViewinfo(managerContact);
	}
	//all-pending
	// http://localhost:4444/api/all-pending
	@GetMapping("all-pending")
	public List<PendingReimbursmentPojo> fetchAllPendingReq() throws SystemException {
		return pendingReimbursmentService.fetchAllPendingReq();
		
	}
	//all-resolved
	// http://localhost:4444/api/all-resolved
	@GetMapping("all-resolved")
	public List<ResolvedReimbursmentPojo> fetchAllResolveReq() throws SystemException {
		return resolvedReimbursmentService.fetchAllResolveReq();
	
	}
	
	// approveORdeny reimbursement request
	// http://localhost:4444/api/all-resolved/approve-or-deny
	@PostMapping("all-resolved/approve-or-deny")
	public ResolvedReimbursmentPojo approveOrDeny(@RequestBody ResolvedReimbursmentPojo resolvedReimbursmentPojo)
			throws SystemException {
				return resolvedReimbursmentService.approveOrDeny(resolvedReimbursmentPojo);
		
	}
	
				/* ========= =============ProofImage==================*/
	//fetch all ImageProofs
	// http://localhost:4444/api/images
	@GetMapping("images")
	public List<ErsProofImagePojo> fetchAllImageProofs() throws SystemException {
		List<ErsProofImagePojo> imagePojoList = ersProofImageImageService.fetchAllImageProofs();
		for(ErsProofImagePojo ersProofImagePojo: imagePojoList) {
			byte[] b = ersProofImagePojo.getTphoto();
			byte[] encodedBase64 = Base64.getEncoder().encode(b);
			
			
			try {
				String base64DataString = new String(encodedBase64, "UTF-8");
				ersProofImagePojo.setPhoto(base64DataString);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return imagePojoList;
	}
	
	// fetch an Image
	// http://localhost:4444/api/images/1
	@GetMapping("images/{reimbursementId}")
	public ErsProofImagePojo fetchProofImage(@PathVariable("reimbursementId") int reimbursementId) {
		return ersProofImageImageService.fetchProofImage(reimbursementId);
	}
	
	// fetch an Image
		// http://localhost:4444/api/images/submit
		@PostMapping("images/submit")
		public ErsProofImagePojo createProofImage(@RequestBody ErsProofImagePojo ersProofImagePojo) {
			try {
				ersProofImageImageService.saveProofImage(ersProofImagePojo);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ersProofImagePojo;
		}
		
	
	
}