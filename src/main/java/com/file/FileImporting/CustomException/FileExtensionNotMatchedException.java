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
public class FileExtensionNotMatchedException extends IOException {
@ExceptionHandler(FileExtensionNotMatchedException.class)
    public ResponseEntity<ErrorApi> HandleFileExtensionNotMatchedException(){
    ErrorApi errorApi=new ErrorApi("BAD_REQUEST","File extension should be xls or xlsx",new Date());
        return new ResponseEntity<>(errorApi,HttpStatus.BAD_REQUEST);
    }
}
