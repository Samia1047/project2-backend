package com.project2springbootrestspringdataers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2springbootrestspringdataers.entity.ErsProofImageEntity;

public interface ErsProofImageRepository extends JpaRepository<ErsProofImageEntity, Integer> {
	
	ErsProofImageEntity getByReimbursementId(int reimbursementId);

}
