package com.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.interview.model.AssetDetails;
import com.interview.model.AssetResponse;

public interface AssetRepository extends JpaRepository<AssetDetails, Long>{

	//@Query("SELECT new com.interview.model.AssetResponse(org.name,emp.firstName,emp.lastName,asset.id,asset.assetName,asset.assetCategory,asset.assetType) FROM OrganizationDetails org JOIN EmployeeDetails emp on emp.id=emp.organization.id JOIN AssetDetails asset on asset.id = asset.employee.id where org.id= ?1 and emp.id=?2")
	@Query("SELECT new com.interview.model.AssetResponse(org.name,emp.firstName,emp.lastName,asset.id,asset.assetName,asset.assetCategory,asset.assetType) FROM OrganizationDetails org JOIN EmployeeDetails emp on org.id=emp.organization.id JOIN AssetDetails asset on emp.id = asset.employee.id where asset.organization.id= ?1 and asset.employee.id=?2")
	public List<AssetResponse> getAssetDetails(long orgId,long empId); 
}
