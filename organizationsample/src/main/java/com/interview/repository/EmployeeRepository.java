package com.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.interview.model.EmployeeDetails;
import com.interview.model.EmployeeResponse;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long>{
	
	@Query("SELECT new com.interview.model.EmployeeResponse(emp.id,org.name,emp.firstName,emp.lastName,emp.gender,emp.salary,emp.position) FROM OrganizationDetails org JOIN EmployeeDetails emp on org.id=emp.organization.id where org.id= ?1")
	public List<EmployeeResponse> empDetails(long id);
}
