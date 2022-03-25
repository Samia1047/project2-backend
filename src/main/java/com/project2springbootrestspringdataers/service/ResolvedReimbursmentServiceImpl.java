package com.project2springbootrestspringdataers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2springbootrestspringdataers.dao.ResolvedReimbursmentRepository;
import com.project2springbootrestspringdataers.entity.ResolvedReimbursmentEntity;
import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.ResolvedReimbursmentPojo;

@Service
public class ResolvedReimbursmentServiceImpl implements ResolvedReimbursmentService{
	
	@Autowired
	ResolvedReimbursmentRepository resolvedReimbursmentRepository;
	
	@Override
	public ResolvedReimbursmentPojo viewReimbursementResolveReq(int reimbursementId) throws SystemException {
		Optional<ResolvedReimbursmentEntity> entity = resolvedReimbursmentRepository.findById(reimbursementId);
		ResolvedReimbursmentPojo resolvedReimbursmentPojo =null;
		if(entity.isPresent()) {
			ResolvedReimbursmentEntity resolvedReimbursmentEntity = entity.get();
			resolvedReimbursmentPojo = new ResolvedReimbursmentPojo(resolvedReimbursmentEntity.getReimbursementId(),
					resolvedReimbursmentEntity.getRequestingEmployeeId(),
					resolvedReimbursmentEntity.getReimbursementAmount(),
					resolvedReimbursmentPojo.isRequestApproved(),
					resolvedReimbursmentEntity.getDateResolved());
		}
		return resolvedReimbursmentPojo;
	}
	
	@Override
	public ResolvedReimbursmentPojo approveOrDeny(ResolvedReimbursmentPojo resolvedReimbursmentPojo)
			throws SystemException {
		ResolvedReimbursmentEntity resolvedReimbursmentEntity = new ResolvedReimbursmentEntity(
				resolvedReimbursmentPojo.getReimbursementId(),
				resolvedReimbursmentPojo.getRequestingEmployeeId(),
				resolvedReimbursmentPojo.getReimbursementAmount(),
				resolvedReimbursmentPojo.isRequestApproved(),
				resolvedReimbursmentPojo.getDateResolved()
				);
		// add restrictions by amount
		if(resolvedReimbursmentPojo.getReimbursementAmount()<=10000) {
		resolvedReimbursmentRepository.saveAndFlush(resolvedReimbursmentEntity);
		resolvedReimbursmentPojo = new ResolvedReimbursmentPojo(
				resolvedReimbursmentEntity.getReimbursementId(),
				resolvedReimbursmentEntity.getRequestingEmployeeId(),
				resolvedReimbursmentEntity.getReimbursementAmount(),
				resolvedReimbursmentEntity.isRequestApproved(),
				resolvedReimbursmentEntity.getDateResolved()
				);
		return resolvedReimbursmentPojo;
		}
		return resolvedReimbursmentPojo;
	}


	@Override
	public List<ResolvedReimbursmentPojo> fetchAllResolveReq() throws SystemException {
		List<ResolvedReimbursmentPojo> allResolvedPojo = new ArrayList<>(); // blank list
		List<ResolvedReimbursmentEntity> allResolveList = resolvedReimbursmentRepository.findAll();
		
		for(ResolvedReimbursmentEntity entity : allResolveList) {
			ResolvedReimbursmentPojo pojo = new ResolvedReimbursmentPojo();
			BeanUtils.copyProperties(entity, pojo);
			allResolvedPojo.add(pojo);
		}
		return allResolvedPojo;
	}



	
}