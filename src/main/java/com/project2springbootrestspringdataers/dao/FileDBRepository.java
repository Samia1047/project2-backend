package com.project2springbootrestspringdataers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project2springbootrestspringdataers.entity.FileDB; 

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}