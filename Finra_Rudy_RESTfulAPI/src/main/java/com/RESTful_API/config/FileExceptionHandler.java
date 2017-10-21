package com.RESTful_API.config;

/**
 * Created by lvdiboy on 10/20/17.
 */
import com.RESTful_API.execption.UploadFailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FileExceptionHandler {

    @ExceptionHandler(value = UploadFailException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleExceptions(UploadFailException e){
        return e.getMessage();
    }


}
