package com.dcservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_CASES")
@Data
public class DcCaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caseId;
	
	private Integer caseNumber;
	
	private Integer appId;
	
	private Integer planId;
}
