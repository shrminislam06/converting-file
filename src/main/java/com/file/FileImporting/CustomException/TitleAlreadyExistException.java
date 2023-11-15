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
public class TitleAlreadyExistException extends IOException {
    @ExceptionHandler(TitleAlreadyExistException.class)
    public ResponseEntity<ErrorApi>titleAlreadyExistException() {
        ErrorApi error=new ErrorApi("BAD_REQUEST","Title already exist..!!",new Date());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
