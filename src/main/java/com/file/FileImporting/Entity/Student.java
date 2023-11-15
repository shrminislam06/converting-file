package com.file.FileImporting.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private  String name;
    private  int age;
    private  String department;
    @ManyToOne
    private Student_file savedStudentFile;

    public Student(String name, int age, String department, Student_file savedStudentFile) {

        this.name = name;
        this.age = age;
        this.department = department;
        this.savedStudentFile = savedStudentFile;
    }
}
