package com.dcservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcservice.bindings.DCSummary;
import com.dcservice.bindings.EducationInfo;
import com.dcservice.bindings.IncomeInfo;
import com.dcservice.bindings.KidsInfo;
import com.dcservice.entity.DcCaseEntity;
import com.dcservice.entity.EducationEntity;
import com.dcservice.entity.IncomeEntity;
import com.dcservice.entity.KidsEntity;
import com.dcservice.entity.PlanEntity;
import com.dcservice.repository.DCCasesRepository;
import com.dcservice.repository.EducationRepository;
import com.dcservice.repository.IncomeRepository;
import com.dcservice.repository.KidsRepository;
import com.dcservice.repository.PlanRepository;

@Service
public class DCServiceImpl implements DCService {
     
	@Autowired
	private DCCasesRepository dcrepo;
	
	@Autowired
	private PlanRepository prepo;
	
	@Autowired
	private EducationRepository edurepo;
	
	@Autowired
	private IncomeRepository irepo;
	
	@Autowired
	private KidsRepository krepo;
	
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
	   List<PlanEntity> lstPlans = prepo.findAll();
	   if(lstPlans != null) {
		   List<String> planNamelst = new ArrayList<>();
		  for(PlanEntity p : lstPlans) {
			  String planName = p.getPlanName();
			  planNamelst.add(planName);
		  }
		  return planNamelst;
	   }
		return null;
	}

	@Override
	public Long addEducationDetails(EducationInfo einfo) {
		EducationEntity eduEntity = new EducationEntity();
		BeanUtils.copyProperties(einfo, eduEntity);
		EducationEntity eduentity = edurepo.save(eduEntity);
		if(eduentity != null) {
			return eduEntity.getCaseNum();
		}
		return null;
	}

	@Override
	public Long addIncomeDetails(IncomeInfo iInfo) {
		IncomeEntity ientity = new IncomeEntity();
		BeanUtils.copyProperties(iInfo, ientity);
		IncomeEntity incomeEntity = irepo.save(ientity);
		if(incomeEntity != null) {
			return incomeEntity.getCaseNum();
		}
		return null;
	}

	@Override
	public Long addkidsDetails(List<KidsInfo> kinfo) {
		KidsEntity kentity = new KidsEntity();
		BeanUtils.copyProperties(kinfo, kentity);
		KidsEntity kidsEntity = krepo.save(kentity);
		if(kidsEntity != null) {
			return kidsEntity.getCaseNum();
		}
		return null;
	}

	@Override
	public DCSummary getSummary(Long caseNum) {
		
		Optional<IncomeEntity> incomeEntity = irepo.findById(caseNum);
		Optional<EducationEntity> eduEntity = edurepo.findById(caseNum);
		Optional<KidsEntity> kidsEntity = krepo.findById(caseNum);
		
		if(incomeEntity != null &&  eduEntity != null && kidsEntity != null) {
			IncomeEntity incomeEntity1 = incomeEntity.get();
			IncomeInfo Iinfo = new IncomeInfo(); 
			BeanUtils.copyProperties(incomeEntity1, Iinfo);
			EducationEntity eduEntity1 = eduEntity.get();
			EducationInfo einfo = new EducationInfo();
			BeanUtils.copyProperties(eduEntity1, einfo);
			KidsEntity kidsEntity1 = kidsEntity.get();
			KidsInfo kinfo = new KidsInfo();
			BeanUtils.copyProperties(kidsEntity1, kinfo);
			
			//create summary class object
			DCSummary dcsum = new DCSummary();
			dcsum.setIInfo(Iinfo);
			dcsum.setEinfo(einfo);
			dcsum.setKinfo(kinfo);
			
			return dcsum;
		}
		return null;
	}

}
