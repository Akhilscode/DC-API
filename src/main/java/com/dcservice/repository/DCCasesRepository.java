package com.dcservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcservice.entity.DcCaseEntity;

public interface DCCasesRepository  extends JpaRepository<DcCaseEntity, Integer>{

}
