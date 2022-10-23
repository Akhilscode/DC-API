package com.dcservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcservice.bindings.DCSummary;
import com.dcservice.bindings.EducationInfo;
import com.dcservice.bindings.IncomeInfo;
import com.dcservice.bindings.KidsInfo;
import com.dcservice.bindings.PlanInfo;
import com.dcservice.entity.CitizenDetailsEntity;
import com.dcservice.entity.DcCaseEntity;
import com.dcservice.entity.EducationEntity;
import com.dcservice.entity.IncomeEntity;
import com.dcservice.entity.KidsEntity;
import com.dcservice.entity.PlanEntity;
import com.dcservice.repository.CitizenDetailsRepository;
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
	
	@Autowired
	private CitizenDetailsRepository cdr;

	@Override
	public Long loadCaseNum(Integer appId) {
		  Optional<CitizenDetailsEntity> cdentity = cdr.findById(appId);
		 if(cdentity.isPresent()) {
			DcCaseEntity dcentity = new DcCaseEntity();
			dcentity.setAppId(appId);
			dcentity = dcrepo.save(dcentity);
            return dcentity.getCaseNum();
		 }
		
		return null;
	}

	@Override
	public Map<Integer, String> getPlanNames() {
		List<PlanEntity> lstPlans = prepo.findAll();
		if (lstPlans != null) {
			Map<Integer, String> planNamelst = new HashMap<>();
			for (PlanEntity p : lstPlans) {
				planNamelst.put(p.getPlanCategoryId(), p.getPlanName()); 
			}
			return planNamelst;
		}
		return null;
	}
	

	@Override
	public Long savePlanSelection(PlanInfo pi) {
	   Optional<DcCaseEntity> dcentity = dcrepo.findById(pi.getCaseNum());
	   if(dcentity.isPresent()) {
		 DcCaseEntity dcCaseEntity = dcentity.get();
		 dcCaseEntity.setPlanCategoryId(pi.getPlanCategoryId());
		 dcrepo.save(dcCaseEntity);
		 return pi.getCaseNum();
	   }
		return null;
	}
	
	@Override
	public Long addIncomeDetails(IncomeInfo iInfo) {
		IncomeEntity ientity = new IncomeEntity();
		BeanUtils.copyProperties(iInfo, ientity);
		IncomeEntity incomeEntity = irepo.save(ientity);
		if (incomeEntity != null) {
			return incomeEntity.getCaseNum();
		}
		return null;
	}
	
		

	@Override
	public Long addEducationDetails(EducationInfo einfo) {
		EducationEntity eduEntity = new EducationEntity();
		BeanUtils.copyProperties(einfo, eduEntity);
		EducationEntity eduentity = edurepo.save(eduEntity);
		if (eduentity != null) {
			return einfo.getCaseNum();
		}
		return null;
	}


	@Override
	public Long addkidsDetails(List<KidsInfo> lstkinfo) {
		
		KidsEntity kidsEntity = null;
		
		for(KidsInfo kf : lstkinfo) {
			KidsEntity kentity = new KidsEntity();
			BeanUtils.copyProperties(kf, kentity);
			 kidsEntity = krepo.save(kentity);
		}
			if (kidsEntity != null) {
				return lstkinfo.get(0).getCaseNum();
		}
		return null;
	}

	@Override
	public DCSummary getSummary(Long caseNum) {
		
		String planName = "";
		
        IncomeEntity ientity = irepo.findByCaseNum(caseNum);
        EducationEntity eduentity = edurepo.findByCaseNum(caseNum);
        List<KidsEntity> lstkentity = krepo.findByCaseNum(caseNum);
        
        Optional<DcCaseEntity> dcentity = dcrepo.findById(caseNum);
        if(dcentity.isPresent()) {
        	Integer planCategoryId = dcentity.get().getPlanCategoryId();
        	 PlanEntity pentity = prepo.findByPlanCategoryId(planCategoryId);
        	if(pentity != null) {
        	     planName = pentity.getPlanName();
        	}
        }
        
        DCSummary summary = new DCSummary();
        summary.setPlanName(planName);
        
        IncomeInfo income = new IncomeInfo();
        BeanUtils.copyProperties(ientity, income);
        summary.setIInfo(income);
          
        EducationInfo education = new EducationInfo();
        BeanUtils.copyProperties(eduentity, education);
        summary.setEinfo(education);
        
        List<KidsInfo> lstkids = new ArrayList<>();
        for(KidsEntity ke : lstkentity) {
        	KidsInfo ki = new KidsInfo();
        	BeanUtils.copyProperties(ke, ki);
        	lstkids.add(ki);
        }
        
        summary.setKinfo(lstkids);
         
		return summary;
	}
	}

	

