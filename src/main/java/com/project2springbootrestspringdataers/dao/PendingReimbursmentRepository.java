package com.project2springbootrestspringdataers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2springbootrestspringdataers.entity.PendingReimbursmentEntity;

@Repository
public interface PendingReimbursmentRepository extends JpaRepository<PendingReimbursmentEntity, Integer>{

}
