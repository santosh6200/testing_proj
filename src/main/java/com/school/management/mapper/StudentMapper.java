package com.school.management.mapper;

import com.school.management.dto.StudentDto;
import com.school.management.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {
        Long departmentId = null;
        if (student.getDepartment() != null) {
            departmentId = student.getDepartment().getId();
        }
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                departmentId
        );
    }

    public static Student mapToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        return student;
    }
}
