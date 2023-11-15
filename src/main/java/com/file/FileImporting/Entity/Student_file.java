package com.file.FileImporting.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student_file {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String file;
    private String title;

}
