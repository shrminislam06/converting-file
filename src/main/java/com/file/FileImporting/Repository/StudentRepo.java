package com.file.FileImporting.Repository;
import com.file.FileImporting.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    boolean existsByName(String name);


}
