package com.project2springbootrestspringdataers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2springbootrestspringdataers.dao.PendingReimbursmentRepository;
import com.project2springbootrestspringdataers.entity.PendingReimbursmentEntity;
import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.PendingReimbursmentPojo;

@Service
public class PendingReimbursmentServiceImpl implements PendingReimbursmentService  {

	@Autowired
	PendingReimbursmentRepository pendingReimbursmentRepository;
	
	@Override
	public PendingReimbursmentPojo submitReimbursementReq(PendingReimbursmentPojo pendingReimbursementPojo)
			throws SystemException {
		PendingReimbursmentEntity pendingReimbursmentEntity = new PendingReimbursmentEntity(
				pendingReimbursementPojo.getReimbursementId(),
				pendingReimbursementPojo.getRequestingEmployeeId(),
				pendingReimbursementPojo.getReimbursementAmount(),
				pendingReimbursementPojo.getDateOfRequest()
				);
		pendingReimbursmentRepository.saveAndFlush(pendingReimbursmentEntity);
		pendingReimbursementPojo = new PendingReimbursmentPojo(
				pendingReimbursmentEntity.getReimbursementId(),
				pendingReimbursmentEntity.getRequestingEmployeeId(),
				pendingReimbursmentEntity.getReimbursementAmount(),
				pendingReimbursmentEntity.getDateOfRequest()
				);
		
		return pendingReimbursementPojo;
	}

	@Override
	public PendingReimbursmentPojo viewReimbursementPendingReq(int reimbursementId) throws SystemException {
		Optional<PendingReimbursmentEntity> entity= pendingReimbursmentRepository.findById(reimbursementId);
		PendingReimbursmentPojo pendingReimbursmentPojo=null;
		if(entity.isPresent()) {
			
			PendingReimbursmentEntity pendingReimbursmentEntity = entity.get();
			pendingReimbursmentPojo = new PendingReimbursmentPojo(
					pendingReimbursmentEntity.getReimbursementId(),
					pendingReimbursmentEntity.getReimbursementId(),
					pendingReimbursmentEntity.getReimbursementAmount(),
					pendingReimbursmentEntity.getDateOfRequest()
					);
		}
			
		return pendingReimbursmentPojo;
	}

	@Override
	public List<PendingReimbursmentPojo> fetchAllPendingReq() throws SystemException {
		List<PendingReimbursmentPojo> allPendingPojo = new ArrayList<>();
		List<PendingReimbursmentEntity> allPendingEntity = pendingReimbursmentRepository.findAll();
		for(PendingReimbursmentEntity entity : allPendingEntity) {
			PendingReimbursmentPojo pendingPojo= new PendingReimbursmentPojo();
			BeanUtils.copyProperties(entity, pendingPojo);
			allPendingPojo.add(pendingPojo);
			
		}
		return allPendingPojo;
	}


//	@Override
//	public List<PendingReimbursmentPojo> fetchAllPendingReq() throws SystemException {
//		List<PendingReimbursmentEntity> entityList = pendingReimbursmentRepository.findAll();
//		List<PendingReimbursmentPojo> pojoList = new ArrayList<>(); // blank list
//		for(PendingReimbursmentEntity entity : entityList) {
//			PendingReimbursmentPojo pojo = new PendingReimbursmentPojo();
//			BeanUtils.copyProperties(entity, pojo);
//			pojoList.add(pojo);
//		}
//		return pojoList;
//	}
	
}

