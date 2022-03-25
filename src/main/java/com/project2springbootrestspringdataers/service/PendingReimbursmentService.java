package com.project2springbootrestspringdataers.service;

import java.util.List;

import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.PendingReimbursmentPojo;

public interface PendingReimbursmentService {
	//Submit or create a reimbursement request.
	PendingReimbursmentPojo submitReimbursementReq(PendingReimbursmentPojo pendingReimbursementPojo)throws SystemException;


	//imp View their pending reimbursement requests. 
	PendingReimbursmentPojo viewReimbursementPendingReq(int reimbursementId)throws SystemException;
	
	//Fetch/read a pending request
//	PendingReimbursmentPojo fetchAPendingRequest(int reimbursementId) throws SystemException;
	
//	imp View all pending requests of all employees. 
	List<PendingReimbursmentPojo> fetchAllPendingReq()throws SystemException;

}
