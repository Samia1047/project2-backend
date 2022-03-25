package com.project2springbootrestspringdataers.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2springbootrestspringdataers.dao.ManagerRepository;
import com.project2springbootrestspringdataers.entity.EmployeeEntity;
import com.project2springbootrestspringdataers.entity.ManagerEntity;
import com.project2springbootrestspringdataers.exception.SystemException;
import com.project2springbootrestspringdataers.pojo.EmployeePojo;
import com.project2springbootrestspringdataers.pojo.ManagerPojo;

@Service
public class ManagerServiceImpl implements ManagerService {
	public static final Logger LOG = LogManager.getLogger(ManagerServiceImpl.class);
	
	@Autowired
	ManagerRepository managerRepository;

	@Override
	public ManagerPojo loginManager(String managerContact, String managerPassword) throws SystemException {
		LOG.info("Entered loginManager() in Service");
		ManagerEntity managerEntity = managerRepository.findByManagerContactAndManagerPassword(managerContact, managerPassword);
		ManagerPojo managerPojo = null;
		if(managerEntity!=null) {
			managerPojo= new ManagerPojo();
			BeanUtils.copyProperties(managerEntity, managerPojo);
		}
		LOG.info("Exited loginManager() in Service");
		return managerPojo;
	}

	@Override
	public ManagerPojo managerViewinfo(String managerContact) throws SystemException {
		LOG.info("Entered managerViewinfo() in Service");
		ManagerEntity managerEntity = managerRepository.findByManagerContact(managerContact);
		ManagerPojo managerPojo = null;
				if(managerEntity!=null) {
					managerPojo = new ManagerPojo();
					BeanUtils.copyProperties(managerEntity, managerPojo);
				}
		LOG.info("Exited managerViewinfo() in Service");
		return managerPojo;
	}

	@Override
	public List<ManagerPojo> fetchAllManagers() throws SystemException {
		LOG.info("Entered fetchAllManagers() in Service");
		List<ManagerEntity> entityList = managerRepository.findAll();
		List<ManagerPojo>	pojoList = new ArrayList<>(); // blank list
		for(ManagerEntity entity : entityList) {
			
			ManagerPojo pojo = new ManagerPojo(); // blank object
			BeanUtils.copyProperties(entity, pojo);
			pojoList.add(pojo);
		}
		LOG.info("Exited fetchAllManagers() in Service");
		return pojoList;
	}
	
	
	
}

