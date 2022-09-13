package com.interview.service;

import java.util.Map;

import com.interview.model.EmployeeRequest;
import com.interview.model.ResponseStatus;

public interface EmployeeService {

	public Map<String, Object> getEmpDetails(long orgId);
	public ResponseStatus addEmpDetails(long orgId, EmployeeRequest request);
	public ResponseStatus updateEmpDetails(EmployeeRequest request);
	public ResponseStatus deleteEmpDetails(long id);
	public ResponseStatus deleteAllEmpDetails();
}
