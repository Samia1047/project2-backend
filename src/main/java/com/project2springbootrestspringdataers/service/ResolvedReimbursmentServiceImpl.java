package com.project2springbootrestspringdataers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2springbootrestspringdataers.dao.ResolvedReimbursmentRepository;
import com.project2springbootrestspringdataers.entity.ResolvedReimbursmentEntity;
import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.ResolvedReimbursmentPojo;

@Service
public class ResolvedReimbursmentServiceImpl implements ResolvedReimbursmentService{
	public static final Logger LOG = LogManager.getLogger(ResolvedReimbursmentServiceImpl.class);
	
	@Autowired
	ResolvedReimbursmentRepository resolvedReimbursmentRepository;
	
	@Override
	public ResolvedReimbursmentPojo viewReimbursementResolveReq(int reimbursementId) throws SystemException {
		LOG.info("Entered viewReimbursementResolveReq() in Service");
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
		LOG.info("Exited viewReimbursementResolveReq() in Service");
		return resolvedReimbursmentPojo;
	}
	
	@Override
	public ResolvedReimbursmentPojo approveOrDeny(ResolvedReimbursmentPojo resolvedReimbursmentPojo)
			throws SystemException {
		LOG.info("Entered approveOrDeny() in Service");
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
		LOG.info("Exited approveOrDeny() in Service");
		return resolvedReimbursmentPojo;
	}


	@Override
	public List<ResolvedReimbursmentPojo> fetchAllResolveReq() throws SystemException {
		LOG.info("Entered fetchAllResolveReq() in Service");
		List<ResolvedReimbursmentPojo> allResolvedPojo = new ArrayList<>(); // blank list
		List<ResolvedReimbursmentEntity> allResolveList = resolvedReimbursmentRepository.findAll();
		
		for(ResolvedReimbursmentEntity entity : allResolveList) {
			ResolvedReimbursmentPojo pojo = new ResolvedReimbursmentPojo();
			BeanUtils.copyProperties(entity, pojo);
			allResolvedPojo.add(pojo);
		}
		LOG.info("Exited fetchAllResolveReq() in Service");
		return allResolvedPojo;
	}



	
}