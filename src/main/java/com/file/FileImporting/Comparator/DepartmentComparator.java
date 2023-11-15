package com.file.FileImporting.Comparator;

import com.file.FileImporting.Entity.Student;
import org.springframework.stereotype.Component;

import java.util.Comparator;
@Component
public class DepartmentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getDepartment().compareToIgnoreCase(o2.getDepartment());
    }
}
