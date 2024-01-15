package com.departmentservice.department.controller;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.departmentservice.department.Dto.DepartmentDto;
import com.departmentservice.department.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	// Build save REST API
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
	    LOGGER.info("Saving department: {}");
	    return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
	}

	
	// Build get by code
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String code) {
	    // Call the service to retrieve a department by code
	    DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);

	    // Create a ResponseEntity based on the result
	    return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}

	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
	    // Call the service to retrieve a list of all departments
	    List<DepartmentDto> departmentDtos = departmentService.getAllDepartment();

	    // Create a ResponseEntity based on the result
	    return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
	}



}
