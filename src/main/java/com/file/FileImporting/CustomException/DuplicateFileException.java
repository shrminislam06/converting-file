package com.file.FileImporting.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.Date;

@Controller
@RestControllerAdvice
public class DuplicateFileException extends IOException {
    @ExceptionHandler(DuplicateFileException.class)
    public ResponseEntity<ErrorApi>duplicateFileException(){
        ErrorApi error=new ErrorApi("BAD_REQUEST","Duplicate File Name Found..!",new Date());
        return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
