package com.project2springbootrestspringdataers.service;

import java.util.List;

import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.ResolvedReimbursmentPojo;

public interface ResolvedReimbursmentService {
	
	/*    ===============Employee==============*/
	//imp View their resolved reimbursement requests.
	ResolvedReimbursmentPojo viewReimbursementResolveReq(int reimbursementId)throws SystemException;
	
	
	
	/*    ===============Manager==============*/

	ResolvedReimbursmentPojo approveOrDeny(ResolvedReimbursmentPojo resolvedReimbursmentPojo) throws SystemException;
	
	
	

	
	//View all resolved requests of all employees.
	 List<ResolvedReimbursmentPojo> fetchAllResolveReq()throws SystemException;
	

}

