package com.interview.service;

import java.util.Map;

import com.interview.model.OrganizationDetails;
import com.interview.model.OrganizationRequest;
import com.interview.model.ResponseStatus;

public interface OrganizationService {
	
	public Map<String, Object> getOrgDetails();
	public OrganizationDetails getOrganizationById(long id);
	public ResponseStatus addOrgDetails(OrganizationRequest request);
	public ResponseStatus updateOrgDetails(OrganizationRequest request);
	public ResponseStatus deleteOrgDetails(long id);
	public ResponseStatus deleteAllOrgDetails();

}
