package com.interview.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.interview.model.OrganizationDetails;
import com.interview.model.OrganizationRequest;
import com.interview.model.ResponseStatus;
import com.interview.repository.OrganizationRepository;
import com.interview.service.OrganizationService;
import com.interview.util.ResourceNotFoundException;

@Service
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	OrganizationRepository repository;

	@Override
	public Map<String, Object> getOrgDetails(){
		Map<String, Object> result = new HashMap<>();
		List<OrganizationDetails> orgDetailList = new ArrayList<>();
		repository.findAll().forEach(orgDetailList::add);
		result.put("orgList", orgDetailList);
		return result;
	}
	
	@Override
	public OrganizationDetails getOrganizationById(long id) {
		OrganizationDetails orgDetails = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization Details not exist with id: " + id));
		return orgDetails;
	}

	@Override
	public ResponseStatus addOrgDetails(OrganizationRequest request){
		ResponseStatus response = new ResponseStatus();
		if(request!=null) {
				OrganizationDetails orgDetails = new OrganizationDetails();
				orgDetails.setId(request.getId());
				orgDetails.setName(request.getName());
				orgDetails.setAddress(request.getAddress());
				orgDetails.setCreatedBy("Govind");
				orgDetails.setCreatedOn(new Timestamp(System.currentTimeMillis()));
				OrganizationDetails result = repository.save(orgDetails);
				if(result!=null) {
					response.setResponseCode("201");
					response.setResponseMessage("Organization Details Successfully created");
				}
		}else {
			response.setResponseCode("400");
			response.setResponseMessage("loginId is missing");
		}
		
		return response;
	}

	@Override
	public ResponseStatus updateOrgDetails(OrganizationRequest request){
		ResponseStatus response = new ResponseStatus();
		if(request!=null) {
				OrganizationDetails orgDetails = repository.findById(request.getId())
		                .orElseThrow(() -> new ResourceNotFoundException("Organization Details not exist with id: " + request.getId()));
				orgDetails.setId(request.getId());
				orgDetails.setName(request.getName());
				orgDetails.setAddress(request.getAddress());
				orgDetails.setModifiedBy("Govind");
				orgDetails.setModifiedOn(new Timestamp(System.currentTimeMillis()));
				repository.save(orgDetails);
				response.setResponseCode("200");
				response.setResponseMessage("Organization Details Successfully updated");
			
		}else {
			response.setResponseCode("400");
			response.setResponseMessage("loginId is missing");
		}
		
		return response;
	}

	@Override
	public ResponseStatus deleteOrgDetails(long id){
		ResponseStatus response = new ResponseStatus();
		try {
			repository.deleteById(id);
			response.setResponseCode("200");
			response.setResponseMessage("Organization Details Successfully deleted");
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Organization Id="+id+ " is not Found in Database");
		}
		return response;
	}

	@Override
	public ResponseStatus deleteAllOrgDetails() {
		ResponseStatus response = new ResponseStatus();
			repository.deleteAll();
			response.setResponseCode("200");
			response.setResponseMessage("Organization All Details Successfully deleted");
		return response;
	}
}
