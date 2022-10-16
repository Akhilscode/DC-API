package com.dcservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcservice.bindings.DCSummary;
import com.dcservice.bindings.EducationInfo;
import com.dcservice.bindings.IncomeInfo;
import com.dcservice.bindings.KidsInfo;
import com.dcservice.entity.DcCaseEntity;
import com.dcservice.repository.DCCasesRepository;

public class DCServiceImpl implements DCService {
     
	@Autowired
	private DCCasesRepository dcrepo;
	
	@Override
	public Long findAppId(Integer appId) {
		Optional<DcCaseEntity> findById = dcrepo.findById(appId);
		if(findById.isPresent()) {
			DcCaseEntity dcCaseEntity = findById.get();
			return dcCaseEntity.getCaseNumber();
		}
		return null;
	}

	@Override
	public List<String> getAllPlans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addEducationDetails(EducationInfo einfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addIncomeDetails(IncomeInfo iInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addkidsDetails(List<KidsInfo> kinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DCSummary getSummary(Integer caseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
