package com.project2springbootrestspringdataers.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2springbootrestspringdataers.dao.ErsProofImageRepository;
import com.project2springbootrestspringdataers.entity.ErsProofImageEntity;
import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.ErsProofImagePojo;

@Service
public class ErsProofImageImageServiceImp implements ErsProofImageImageService {

	@Autowired
	ErsProofImageRepository ersProofImageRepository;
	@Override
	public ErsProofImagePojo saveProofImage(ErsProofImagePojo ersProofImagePojo)throws SystemException {
		
		ErsProofImageEntity ersProofImageEntity = new ErsProofImageEntity();
		BeanUtils.copyProperties(ersProofImagePojo, ersProofImageEntity);
		
		// for photo or image
		try {
			ersProofImageEntity.setTphoto(ersProofImageEntity.getFile().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ersProofImageEntity+ "from service ersProofImageEntity");
		ersProofImageRepository.save(ersProofImageEntity);
		
		
		return ersProofImagePojo;
	}
	

	@Override
	public List<ErsProofImagePojo> fetchAllImageProofs() throws SystemException {
		
		List<ErsProofImageEntity> entityList = ersProofImageRepository.findAll();
		List<ErsProofImagePojo> pojoList = new ArrayList<>(); // blank list
		for(ErsProofImageEntity entity : entityList) {
			ErsProofImagePojo pojo = new ErsProofImagePojo();
			BeanUtils.copyProperties(entity, pojo);
			pojoList.add(pojo);
		}
		return pojoList;
	}
	
	@Override
	public ErsProofImagePojo fetchProofImage(int reimbursementId) {
		ErsProofImageEntity ErsProofImageEntity = ersProofImageRepository.getByReimbursementId(reimbursementId);
		ErsProofImagePojo ersProofImagePojo = new ErsProofImagePojo();
		BeanUtils.copyProperties(ErsProofImageEntity, ersProofImagePojo);
		return ersProofImagePojo;
	}



}
