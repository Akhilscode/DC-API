package com.dcservice.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcservice.entity.KidsEntity;

public interface KidsRepository  extends JpaRepository<KidsEntity, Serializable>{

	public List<KidsEntity>  findByCaseNum(Long caseNum);
}
