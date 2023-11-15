package com.file.FileImporting.Comparator;

import com.file.FileImporting.Entity.Student;
import org.springframework.stereotype.Component;

import java.util.Comparator;
@Component
public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
//        int comp=0;
//         comp= o1.getName().compareTo(o2.getName());
//        if(comp==0){
//            comp= o1.getAge()-o2.getAge();
//        }
        return o1.getAge()-o2.getAge();
    }
}
