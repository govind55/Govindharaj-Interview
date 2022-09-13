package com.interview.service;

import java.util.Map;

import com.interview.model.AssetRequest;
import com.interview.model.ResponseStatus;

public interface AssetService {
	
	public Map<String, Object> getAssetDetails(long orgId, long empId);
	public ResponseStatus addAssetDetails(long orgId, long empId, AssetRequest request);
	public ResponseStatus updateAssetDetails(AssetRequest request);
	public ResponseStatus deleteAssetDetails(long id);
	public ResponseStatus deleteAllAssetDetails();
}
