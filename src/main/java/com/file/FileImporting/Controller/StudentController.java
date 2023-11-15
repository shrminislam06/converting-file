package com.file.FileImporting.Controller;

import com.file.FileImporting.Entity.Student;
import com.file.FileImporting.Entity.Student_file;
import com.file.FileImporting.Service.ExcelService;
import com.file.FileImporting.Service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
public class StudentController {
    ExcelService excelService;
    StudentService studentService;


    public StudentController(ExcelService excelService, StudentService studentService) {
        this.excelService = excelService;
        this.studentService = studentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam(value = "title", required = false) String title) throws IOException {


        excelService.uplodFile(file, title);
        return ResponseEntity.ok().body("File uploaded successfully!");
    }


    @GetMapping("/students")
    public List<Student> getALl(@RequestParam(name = "sortBy",required = false,defaultValue = "name")String sortBy,
                                @RequestParam(name = "sortIn",required = false,defaultValue = "asc")String sortIn) {

       return studentService.getAll(sortBy,sortIn);
    }
}

