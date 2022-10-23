package com.dcservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcservice.entity.CitizenDetailsEntity;

public interface CitizenDetailsRepository extends JpaRepository<CitizenDetailsEntity, Integer> {

}
