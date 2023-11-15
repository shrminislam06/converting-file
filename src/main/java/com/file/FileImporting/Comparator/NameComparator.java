package com.file.FileImporting.Comparator;

import com.file.FileImporting.Entity.Student;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class NameComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }


//    Comparator<Student>= Comparator.comparing(Student::getName);
}
