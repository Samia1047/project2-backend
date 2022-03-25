package com.project2springbootrestspringdataers.service;

import java.util.ArrayList;
import java.util.List;

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
	
	@Autowired
	ManagerRepository managerRepository;

	@Override
	public ManagerPojo loginManager(String managerContact, String managerPassword) throws SystemException {
		ManagerEntity managerEntity = managerRepository.findByManagerContactAndManagerPassword(managerContact, managerPassword);
		ManagerPojo managerPojo = null;
		if(managerEntity!=null) {
			managerPojo= new ManagerPojo();
			BeanUtils.copyProperties(managerEntity, managerPojo);
		}
		
		return managerPojo;
	}

	@Override
	public ManagerPojo managerViewinfo(String managerContact) throws SystemException {
		
		ManagerEntity managerEntity = managerRepository.findByManagerContact(managerContact);
		ManagerPojo managerPojo = null;
				if(managerEntity!=null) {
					managerPojo = new ManagerPojo();
					BeanUtils.copyProperties(managerEntity, managerPojo);
				}
		return managerPojo;
	}

	@Override
	public List<ManagerPojo> fetchAllManagers() throws SystemException {
		List<ManagerEntity> entityList = managerRepository.findAll();
		List<ManagerPojo>	pojoList = new ArrayList<>(); // blank list
		for(ManagerEntity entity : entityList) {
			
			ManagerPojo pojo = new ManagerPojo(); // blank object
			BeanUtils.copyProperties(entity, pojo);
			pojoList.add(pojo);
		}
		return pojoList;
	}
	
	
	
}

