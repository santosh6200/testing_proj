package com.school.management.controller;

import com.school.management.dto.DepartmentDto;
import com.school.management.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;
    private com.school.management.service.StudentService studentService;

    // Build Add Department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    // Build Get All Departments REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    // Build Search Departments REST API
    @GetMapping("/search")
    public ResponseEntity<List<DepartmentDto>> searchDepartments(@RequestParam("query") String query) {
        List<DepartmentDto> departments = departmentService.searchDepartments(query);
        return ResponseEntity.ok(departments);
    }

    // Build Update Department REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto updatedDepartment) {
        DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);
        return ResponseEntity.ok(departmentDto);
    }

    // Build Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully!");
    }

    // Build Get Students by Department REST API
    @GetMapping("{id}/students")
    public ResponseEntity<List<com.school.management.dto.StudentDto>> getStudentsByDepartment(@PathVariable("id") Long departmentId) {
        List<com.school.management.dto.StudentDto> students = studentService.getStudentsByDepartment(departmentId);
        return ResponseEntity.ok(students);
    }

    // Intentional Error Endpoint for Testing Logs
    @GetMapping("/test/force-error")
    public ResponseEntity<String> forceErrorEndpoint() {
        throw new RuntimeException("This is an intentionally forced error for testing logs!");
    }
}
