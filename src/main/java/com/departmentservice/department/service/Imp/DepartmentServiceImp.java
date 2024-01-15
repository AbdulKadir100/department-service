package com.departmentservice.department.service.Imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.departmentservice.department.Dto.DepartmentDto;
import com.departmentservice.department.entity.Department;
import com.departmentservice.department.repository.DepartmentRepository;
import com.departmentservice.department.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService{
	private DepartmentRepository departmentRepository;
	private ModelMapper mapper;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
	    
	    // Using a mapper to convert the DepartmentDto to a Department entity
	    Department department = mapper.map(departmentDto, Department.class);
	    
	    // Saving the Department entity using the repository
	    Department savedDepartment = departmentRepository.save(department);
	    
	    // Using a mapper to convert the saved Department entity to a DepartmentDto
	    return mapper.map(savedDepartment, DepartmentDto.class);
	}


	@Override
	public DepartmentDto getDepartmentByCode(String code) {
	    // Retrieve a Department entity from the repository by department code
	    Department department = departmentRepository.findByDepartmentCode(code);
	    
	    // Check if the department was found
	    if (department != null) {
	        // Map the Department entity to a DepartmentDto and return
	        return mapper.map(department, DepartmentDto.class);
	    } else {
	        // If the department is not found, return null
	        return null;
	    }
	}



	@Override
	public List<DepartmentDto> getAllDepartment() {
		// Retrieve a list of all Department entities from the repository
	    List<Department> departmentList = departmentRepository.findAll();
	    
	    // Map each Department entity to a DepartmentDto using the mapToDto method
	    return departmentList.stream()
	            .map((department) -> mapToDto(department))
	            .collect(Collectors.toList());
	}
	
	private DepartmentDto mapToDto(Department department) {
	    // Use the mapper to convert the Department entity to a DepartmentDto
	    return mapper.map(department, DepartmentDto.class);
	}
}
