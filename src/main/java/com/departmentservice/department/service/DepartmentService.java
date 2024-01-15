package com.departmentservice.department.service;

import java.util.List;

import com.departmentservice.department.Dto.DepartmentDto;

public interface DepartmentService {

    // Method to save a DepartmentDto
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    // Method to retrieve a DepartmentDto by code
    DepartmentDto getDepartmentByCode(String code);

    // Method to retrieve a list of all DepartmentDto objects
    List<DepartmentDto> getAllDepartment();
}

