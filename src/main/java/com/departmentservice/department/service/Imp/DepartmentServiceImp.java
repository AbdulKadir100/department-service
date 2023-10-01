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
		Department department = mapper.map(departmentDto, Department.class);
		
		Department savedDepartment = departmentRepository.save(department);
		
		
		return mapper.map(savedDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		Department department = departmentRepository.findByDepartmentCode(code);
		return mapper.map(department, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {
		List<Department> emList = departmentRepository.findAll();
		return emList.stream()
				.map((depart) -> maptoDto(depart)).collect(Collectors.toList());
				
	}
	
	public DepartmentDto maptoDto(Department department) {
		return mapper.map(department, DepartmentDto.class);
	}

}
