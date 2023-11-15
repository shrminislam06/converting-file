package com.file.FileImporting.Service;

import com.file.FileImporting.CustomException.DuplicateFileException;
import com.file.FileImporting.CustomException.FileExtensionNotMatchedException;
import com.file.FileImporting.CustomException.NameAlreadyExistException;
import com.file.FileImporting.CustomException.TitleAlreadyExistException;
import com.file.FileImporting.Entity.Student;
import com.file.FileImporting.Entity.Student_file;
import com.file.FileImporting.Repository.StudentFileRepo;
import com.file.FileImporting.Repository.StudentRepo;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExcelService {

    StudentRepo studentRepo;
    StudentFileRepo studentFileRepo;

    public ExcelService(StudentRepo studentRepo, StudentFileRepo studentFileRepo) {
        this.studentRepo = studentRepo;
        this.studentFileRepo = studentFileRepo;
    }



    public void uplodFile(MultipartFile file,String title) throws IOException {
        String extnsn = FilenameUtils.getExtension(file.getOriginalFilename());

        if (!extnsn.equals("xls") && !extnsn.equals("xlsx")) {
            throw new FileExtensionNotMatchedException();
        }
        if (studentFileRepo.findByFile(file.getOriginalFilename()).isPresent()) {
            throw new DuplicateFileException();
        }

        if (studentFileRepo.findByTitle(title).isPresent()) {
            throw new TitleAlreadyExistException();
        }
        Student_file studentFile = new Student_file();
        studentFile.setFile(file.getOriginalFilename());
        studentFile.setTitle(title);
        Student_file savedStudentFile = studentFileRepo.save(studentFile);

        Set<Student> studentList = new HashSet<>();
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }

            String name = row.getCell(0).getStringCellValue();
            int age = (int) row.getCell(1).getNumericCellValue();
            String department = row.getCell(2).getStringCellValue();

            if (studentRepo.existsByName(name)) {
                throw new NameAlreadyExistException();
            }
            studentList.add(new Student(name, age, department, savedStudentFile));
            studentRepo.saveAll(studentList);
        }

    }


}
