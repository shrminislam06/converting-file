package com.file.FileImporting.CustomException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class ErrorApi {

    private String Error;
    private String Descripton;
    private Date Date;

    public ErrorApi( String error, String descripton, java.util.Date date) {

        Error = error;
        Descripton = descripton;
        Date = date;
    }
}
