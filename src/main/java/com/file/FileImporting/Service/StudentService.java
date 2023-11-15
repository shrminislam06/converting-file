package com.file.FileImporting.Service;

import com.file.FileImporting.Comparator.AgeComparator;
import com.file.FileImporting.Comparator.DepartmentComparator;
import com.file.FileImporting.Comparator.NameComparator;
import com.file.FileImporting.Entity.Student;
import com.file.FileImporting.Repository.StudentFileRepo;
import com.file.FileImporting.Repository.StudentRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;

    }

    public List<Student> getAll(String sortBy, String sortIn) {
        Sort.Direction direction = sortIn.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, sortBy);
        return studentRepo.findAll(sort);
    }
}











