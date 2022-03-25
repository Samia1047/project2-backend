package com.project2springbootrestspringdataers.service;

import java.util.List;

import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.ErsProofImagePojo;

public interface ErsProofImageImageService {
	
	ErsProofImagePojo saveProofImage(ErsProofImagePojo ersProofImagePojo) throws SystemException;
	ErsProofImagePojo fetchProofImage(int  reimbursementId);
	List<ErsProofImagePojo> fetchAllImageProofs() throws SystemException;

	

}
