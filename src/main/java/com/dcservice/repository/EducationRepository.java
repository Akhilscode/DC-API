package com.dcservice.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcservice.entity.EducationEntity;

public interface EducationRepository extends JpaRepository<EducationEntity, Serializable>{

}
