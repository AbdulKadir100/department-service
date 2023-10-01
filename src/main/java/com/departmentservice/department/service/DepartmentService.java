package com.departmentservice.department.service;

import java.util.List;

import com.departmentservice.department.Dto.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentByCode(String code);
	List<DepartmentDto> getAllDepartment();

}
