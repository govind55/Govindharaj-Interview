package com.interview.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.interview.model.AssetDetails;
import com.interview.model.AssetRequest;
import com.interview.model.AssetResponse;
import com.interview.model.EmployeeDetails;
import com.interview.model.OrganizationDetails;
import com.interview.model.ResponseStatus;
import com.interview.repository.AssetRepository;
import com.interview.service.AssetService;
import com.interview.util.ResourceNotFoundException;
@Service
public class AssetServiceImpl implements AssetService{

	@Autowired
	AssetRepository repository;
	@Override
	public Map<String, Object> getAssetDetails(long orgId, long empId){
		Map<String, Object> result = new HashMap<>();
		List<AssetResponse> assetDetailList = new ArrayList<>();
		assetDetailList = repository.getAssetDetails(orgId,empId);
		result.put("AssetDetailList", assetDetailList);
		return result;
	}

	@Override
	public ResponseStatus addAssetDetails(long orgId, long empId, AssetRequest request){
		ResponseStatus response = new ResponseStatus();
		if(request!=null) {
				OrganizationDetails organization = new OrganizationDetails();
				organization.setId(orgId);
				EmployeeDetails employee = new EmployeeDetails();
				employee.setId(empId);
				AssetDetails assetDetails = new AssetDetails();
				assetDetails.setId(request.getId());
				assetDetails.setAssetName(request.getAssetName());
				assetDetails.setAssetCategory(request.getAssetCategory());
				assetDetails.setAssetType(request.getAssetType());
				assetDetails.setPrice(request.getPrice());
				assetDetails.setPurchaseDate(request.getPurchaseDate());
				assetDetails.setExpireDate(request.getExpireDate());
				assetDetails.setCreatedBy("Govind");
				assetDetails.setCreatedOn(new Timestamp(System.currentTimeMillis()));
				assetDetails.setOrganization(organization);
				assetDetails.setEmployee(employee);
				AssetDetails result = repository.save(assetDetails);
				if(result!=null) {
					response.setResponseCode("201");
					response.setResponseMessage("Asset Details Successfully created");
				}
		}else {
			response.setResponseCode("400");
			response.setResponseMessage("loginId is missing");
		}
		
		return response;
	}

	@Override
	public ResponseStatus updateAssetDetails(AssetRequest request){
		ResponseStatus response = new ResponseStatus();
		if(request!=null) {
				AssetDetails assetDetails = repository.findById(request.getId())
		                .orElseThrow(() -> new ResourceNotFoundException("Asset Details not exist with id: " + request.getId()));
				assetDetails.setId(request.getId());
				assetDetails.setAssetName(request.getAssetName());
				assetDetails.setAssetCategory(request.getAssetCategory());
				assetDetails.setAssetType(request.getAssetType());
				assetDetails.setPrice(request.getPrice());
				assetDetails.setPurchaseDate(request.getPurchaseDate());
				assetDetails.setExpireDate(request.getExpireDate());
				assetDetails.setModifiedBy("Govind");
				assetDetails.setModifiedOn(new Timestamp(System.currentTimeMillis()));
				repository.save(assetDetails);
				response.setResponseCode("200");
				response.setResponseMessage("Asset Details Successfully Updated");
		}else {
			response.setResponseCode("400");
			response.setResponseMessage("loginId is missing");
		}
		
		return response;
	}

	@Override
	public ResponseStatus deleteAssetDetails(long id){
		ResponseStatus response = new ResponseStatus();
		try {
			repository.deleteById(id);
			response.setResponseCode("200");
			response.setResponseMessage("Asset Details Successfully deleted");
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Asset Id="+id+" is not Found in Database");
		}		 
		return response;
	}
	
	@Override
	public ResponseStatus deleteAllAssetDetails() {
		ResponseStatus response = new ResponseStatus();
			repository.deleteAll();
			response.setResponseCode("200");
			response.setResponseMessage("Asset All Details Successfully deleted");
		return response;
	}

}
