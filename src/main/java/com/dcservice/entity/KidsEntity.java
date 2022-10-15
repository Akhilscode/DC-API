package com.dcservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="CHILDREN_MASTER")
@Data
public class KidsEntity {

	private Integer childrenId;
	private Long caseNum;	
	private String name;
	private Integer age;
	private Long ssn;
	
	@CreationTimestamp
	@Column(name="CREATED_DATE", updatable = false )
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(name="UPDATED_DATE",  insertable = false )
	private LocalDate updatedDate;
	private String createdBy;
	private String updatedBy;
}
