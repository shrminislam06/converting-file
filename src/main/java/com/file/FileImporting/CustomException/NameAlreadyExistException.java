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
public class NameAlreadyExistException extends IOException {
    @ExceptionHandler(NameAlreadyExistException.class)
    public ResponseEntity<ErrorApi>nameAlreadyExistException(){
        ErrorApi errorApi=new ErrorApi("BAD_REQUEST","Duplicate Student Name Found..!!",new Date());
        return new ResponseEntity<>(errorApi, HttpStatus.BAD_REQUEST);
    }
}
