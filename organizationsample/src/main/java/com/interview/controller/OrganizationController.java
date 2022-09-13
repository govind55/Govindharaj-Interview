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
import org.springframework.web.bind.annotation.RestController;

import com.interview.model.OrganizationDetails;
import com.interview.model.OrganizationRequest;
import com.interview.model.ResponseStatus;
import com.interview.service.OrganizationService;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {

	@Autowired
	OrganizationService orgService;

	@GetMapping("/getOrgDetails")
	public ResponseEntity<Object> getOrgDetails() {
		Map<String, Object> response = new HashMap<>();
		response = orgService.getOrgDetails();
		if (response.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	}
	
	@GetMapping("/getOrgDetails/{id}")
	public ResponseEntity<Object> getOrganizationById(@PathVariable("id") long id) {
		OrganizationDetails organizationDetails = orgService.getOrganizationById(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(organizationDetails);
	}

	@PostMapping("/addOrgDetails")
	public ResponseEntity<Object> addOrgDetails(@RequestBody OrganizationRequest request) {
		ResponseStatus response = new ResponseStatus();
		response = orgService.addOrgDetails(request);
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.parseMediaType("application/xml")).body(response);
	}

	@PutMapping("/updateOrgDetails")
	public ResponseEntity<Object> updateOrgDetails(@RequestBody OrganizationRequest request) {
		ResponseStatus response = new ResponseStatus();
		response = orgService.updateOrgDetails(request);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	}

	@DeleteMapping("/deleteOrgDetails/{id}")
	public ResponseEntity<Object> deleteOrgDetails(@PathVariable long id) {
		ResponseStatus response = new ResponseStatus();
		response = orgService.deleteOrgDetails(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	}
	
	@DeleteMapping("/deleteAllOrgDetails")
	  public ResponseEntity<Object> deleteAllOrgDetails() {
		ResponseStatus response = new ResponseStatus();
		response =orgService.deleteAllOrgDetails();	    
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	  }

}
