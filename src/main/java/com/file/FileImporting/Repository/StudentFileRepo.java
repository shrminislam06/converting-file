package com.file.FileImporting.Repository;

import com.file.FileImporting.Entity.Student;
import com.file.FileImporting.Entity.Student_file;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentFileRepo extends JpaRepository<Student_file,Integer> {


    Optional<Object> findByTitle(String title);

 Optional< Object> findByFile(String file);
}
