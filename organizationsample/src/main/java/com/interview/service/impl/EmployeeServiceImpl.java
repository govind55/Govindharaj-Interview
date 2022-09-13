package com.interview.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.interview.model.EmployeeDetails;
import com.interview.model.EmployeeRequest;
import com.interview.model.EmployeeResponse;
import com.interview.model.OrganizationDetails;
import com.interview.model.ResponseStatus;
import com.interview.repository.EmployeeRepository;
import com.interview.service.EmployeeService;
import com.interview.util.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository repository;
	@Override
	public Map<String, Object> getEmpDetails(long orgId){
		Map<String, Object> result = new HashMap<>();
		List<EmployeeResponse> empDetailList = new ArrayList<>();
		empDetailList = repository.empDetails(orgId);
		result.put("EmployeeList", empDetailList); 
		return result;
	}
	@Override
	public ResponseStatus addEmpDetails(long orgId, EmployeeRequest request){
		ResponseStatus response = new ResponseStatus();
		if(request!=null) {
				EmployeeDetails empDetails = new EmployeeDetails();
				OrganizationDetails organization = new OrganizationDetails();
				organization.setId(orgId);
				empDetails.setId(request.getId());
				empDetails.setFirstName(request.getFirstName());
				empDetails.setLastName(request.getLastName());
				empDetails.setGender(request.getGender());
				empDetails.setSalary(request.getSalary());
				empDetails.setPosition(request.getPosition());
				empDetails.setCreatedBy("Govind");
				empDetails.setCreatedOn(new Timestamp(System.currentTimeMillis()));
				empDetails.setOrganization(organization);
				EmployeeDetails result = repository.save(empDetails);
				if(result!=null) {
					response.setResponseCode("201");
					response.setResponseMessage("Employee Details Successfully created");
				}
		}else {
			response.setResponseCode("400");
			response.setResponseMessage("loginId is missing");
		}
		
		return response;
	}

	@Override
	public ResponseStatus updateEmpDetails(EmployeeRequest request){
		ResponseStatus response = new ResponseStatus();
		if(request!=null) {
				EmployeeDetails empDetails = repository.findById(request.getId())
		                .orElseThrow(() -> new ResourceNotFoundException("Employee Details not exist with id: " + request.getId()));
				empDetails.setId(request.getId());
				empDetails.setFirstName(request.getFirstName());
				empDetails.setLastName(request.getLastName());
				empDetails.setGender(request.getGender());
				empDetails.setSalary(request.getSalary());
				empDetails.setPosition(request.getPosition());
				empDetails.setModifiedBy("Govind");
				empDetails.setModifiedOn(new Timestamp(System.currentTimeMillis()));
				repository.save(empDetails);
				response.setResponseCode("200");
				response.setResponseMessage("Employee Details Successfully Updated");
		}else {
			response.setResponseCode("400");
			response.setResponseMessage("loginId is missing");
		}
		
		return response;
	}

	@Override
	public ResponseStatus deleteEmpDetails(long id){
		ResponseStatus response = new ResponseStatus();
		try {
			repository.deleteById(id);
			response.setResponseCode("200");
			response.setResponseMessage("Employee Details Successfully deleted");
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Employee Id="+id+" is not Found in Database");
		}
		return response;
	}
	
	@Override
	public ResponseStatus deleteAllEmpDetails() {
		ResponseStatus response = new ResponseStatus();
			repository.deleteAll();
			response.setResponseCode("200");
			response.setResponseMessage("Employee All Details Successfully deleted");
		return response;
	}

}
