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

import com.interview.model.EmployeeRequest;
import com.interview.model.ResponseStatus;
import com.interview.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/getEmpDetails")
	public ResponseEntity<Object> getEmpDetails(@RequestParam long orgId) {
		Map<String, Object> response = new HashMap<>();
		response = empService.getEmpDetails(orgId);
		if (response.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	}
	@PostMapping("/addEmpDetails/{orgId}")
	public ResponseEntity<Object> addEmpDetails(@PathVariable long orgId, @RequestBody EmployeeRequest request) {
		ResponseStatus response = new ResponseStatus();
		response = empService.addEmpDetails(orgId, request);
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.parseMediaType("application/xml")).body(response);
	}

	@PutMapping("/updateEmpDetails")
	public ResponseEntity<Object> updateEmpDetails(@RequestBody EmployeeRequest request) {
		ResponseStatus response = new ResponseStatus();
		response = empService.updateEmpDetails(request);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	}

	@DeleteMapping("/deleteEmpDetails/{id}")
	public ResponseEntity<Object> deleteEmpDetails(@PathVariable int id) {
		ResponseStatus response = new ResponseStatus();
		response = empService.deleteEmpDetails(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	}
	@DeleteMapping("/deleteAllEmpDetails")
	  public ResponseEntity<Object> deleteAllEmployeeDetails() {
		ResponseStatus response = new ResponseStatus();
		response =empService.deleteAllEmpDetails();	    
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/xml")).body(response);
	  }
}
