package com.departmentservice.department.controller;

import java.util.List;

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
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	// Build save REST API
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		return new ResponseEntity<>(departmentService.saveDepartment(departmentDto),HttpStatus.CREATED);
	}
	
	// Build get by code
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String code){
		return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAll(){
		return new ResponseEntity<>(departmentService.getAllDepartment(),HttpStatus.OK);
	}


}
