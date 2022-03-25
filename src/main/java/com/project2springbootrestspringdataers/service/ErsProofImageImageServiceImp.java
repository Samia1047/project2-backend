package com.project2springbootrestspringdataers.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2springbootrestspringdataers.dao.ErsProofImageRepository;
import com.project2springbootrestspringdataers.entity.ErsProofImageEntity;
import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.ErsProofImagePojo;

@Service
public class ErsProofImageImageServiceImp implements ErsProofImageImageService {
	public static final Logger LOG = LogManager.getLogger(ErsProofImageImageServiceImp.class);

	@Autowired
	ErsProofImageRepository ersProofImageRepository;
	@Override
	public ErsProofImagePojo saveProofImage(ErsProofImagePojo ersProofImagePojo)throws SystemException {
		LOG.info("Entered saveProofImage() in Service");
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
		
		LOG.info("Exited saveProofImage() in Service");
		return ersProofImagePojo;
	}
	

	@Override
	public List<ErsProofImagePojo> fetchAllImageProofs() throws SystemException {
		LOG.info("Entered fetchAllImageProofs() in Service");
		List<ErsProofImageEntity> entityList = ersProofImageRepository.findAll();
		List<ErsProofImagePojo> pojoList = new ArrayList<>(); // blank list
		for(ErsProofImageEntity entity : entityList) {
			ErsProofImagePojo pojo = new ErsProofImagePojo();
			BeanUtils.copyProperties(entity, pojo);
			pojoList.add(pojo);
		}
		LOG.info("Exited fetchAllImageProofs() in Service");
		return pojoList;
	}
	
	@Override
	public ErsProofImagePojo fetchProofImage(int reimbursementId) {
		LOG.info("Entered fetchProofImage() in Service");
		ErsProofImageEntity ErsProofImageEntity = ersProofImageRepository.getByReimbursementId(reimbursementId);
		ErsProofImagePojo ersProofImagePojo = new ErsProofImagePojo();
		BeanUtils.copyProperties(ErsProofImageEntity, ersProofImagePojo);
		LOG.info("Exited fetchProofImage() in Service");
		return ersProofImagePojo;
	}



}
