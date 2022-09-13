package com.interview.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.model.AssetRequest;
import com.interview.model.ResponseStatus;
import com.interview.service.AssetService;

@RestController
@RequestMapping(value="/asset")
public class AssetController {
	
	@Autowired
	AssetService assetService;
	
	@GetMapping("/getAssetDetails")
	public ResponseEntity<Object> getAssetDetails(@RequestParam long orgId,@RequestParam long empId){
		Map<String, Object> response = new HashMap<>();
		response =assetService.getAssetDetails(orgId,empId);
		if (response.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	}
	@PostMapping("/addAssetDetails/{orgId}/{empId}")
	public ResponseEntity<Object> addAssetDetails(@PathVariable long orgId, @PathVariable long empId,@RequestBody AssetRequest request){
		ResponseStatus response = new ResponseStatus();
		response = assetService.addAssetDetails(orgId, empId, request);
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.parseMediaType("application/xml")).body(response);
	}
	
	@PutMapping("/updateAssetDetails")
	public ResponseEntity<Object> updateAssetDetails(@RequestBody AssetRequest request) {
		ResponseStatus response = new ResponseStatus();
		response = assetService.updateAssetDetails(request);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	}
	
	@DeleteMapping("/deleteAssetDetails/{id}")
	public ResponseEntity<Object> deleteAssetDetails(@PathVariable long id) {
		ResponseStatus response = new ResponseStatus();
		response = assetService.deleteAssetDetails(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	}
	
	@DeleteMapping("/deleteAllAssetDetails")
	  public ResponseEntity<Object> deleteAllEmployeeDetails() {
		ResponseStatus response = new ResponseStatus();
		response =assetService.deleteAllAssetDetails();	    
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	  }
	 

}
