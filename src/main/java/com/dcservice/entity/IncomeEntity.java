package com.dcservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Entity
@Table(name="EDUCTION_MASTER")
@Data
public class IncomeEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer incomeId;
private Integer caseNum;
private Long empIncome;
private Long propertyIncome;
private Long otherIncome;

@CreationTimestamp
@Column(name="CREATED_DATE", updatable = false )
private LocalDate createdDate;
@UpdateTimestamp
@Column(name="UPDATED_DATE",  insertable = false )
private LocalDate updatedDate;
private String createdBy;
private String updatedBy;

}
