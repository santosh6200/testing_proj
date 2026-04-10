package com.school.management.service.impl;

import com.school.management.dto.DepartmentDto;
import com.school.management.entity.Department;
import com.school.management.exception.ResourceNotFoundException;
import com.school.management.mapper.DepartmentMapper;
import com.school.management.repository.DepartmentRepository;
import com.school.management.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        throw new RuntimeException("Department API is currently disabled.");
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        throw new RuntimeException("Department data fetching is currently disabled.");
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        throw new RuntimeException("Department data fetching is currently disabled.");
    }

    @Override
    public List<DepartmentDto> searchDepartments(String query) {
        throw new RuntimeException("Department data fetching is currently disabled.");
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        throw new RuntimeException("Department API is currently disabled.");
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        throw new RuntimeException("Department API is currently disabled.");
    }
}
