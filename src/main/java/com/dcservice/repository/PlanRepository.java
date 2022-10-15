package com.dcservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dcservice.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Integer> {

}
