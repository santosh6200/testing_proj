package com.school.management.service.impl;

import com.school.management.dto.StudentDto;
import com.school.management.entity.Student;
import com.school.management.exception.ResourceNotFoundException;
import com.school.management.mapper.StudentMapper;
import com.school.management.repository.StudentRepository;
import com.school.management.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private com.school.management.repository.DepartmentRepository departmentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        
        if (studentDto.getDepartmentId() != null) {
            com.school.management.entity.Department department = departmentRepository.findById(studentDto.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with given id: " + studentDto.getDepartmentId()));
            student.setDepartment(department);
        }

        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist with given id: " + studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> searchStudents(String query) {
        List<Student> students = studentRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(query, query);
        return students.stream().map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist with given id: " + studentId));

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());

        if (updatedStudent.getDepartmentId() != null) {
            com.school.management.entity.Department department = departmentRepository.findById(updatedStudent.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with given id: " + updatedStudent.getDepartmentId()));
            student.setDepartment(department);
        } else {
            student.setDepartment(null);
        }

        Student updatedStudentObj = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist with given id: " + studentId));
        studentRepository.deleteById(studentId);
    }
}
