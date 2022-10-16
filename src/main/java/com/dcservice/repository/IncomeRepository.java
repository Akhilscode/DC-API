package com.dcservice.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcservice.entity.IncomeEntity;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Serializable>{

}
