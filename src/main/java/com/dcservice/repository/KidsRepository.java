package com.dcservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcservice.entity.KidsEntity;

public interface KidsRepository  extends JpaRepository<KidsEntity, Integer>{

	
}
