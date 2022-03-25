package com.project2springbootrestspringdataers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2springbootrestspringdataers.entity.ResolvedReimbursmentEntity;

@Repository
public interface ResolvedReimbursmentRepository extends JpaRepository<ResolvedReimbursmentEntity, Integer>{

}
