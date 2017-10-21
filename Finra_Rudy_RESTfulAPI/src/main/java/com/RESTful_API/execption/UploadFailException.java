package com.RESTful_API.execption;

/**
 * Created by lvdiboy on 10/20/17.
 */
public class UploadFailException extends RuntimeException {
    public UploadFailException(String message){
        super(message);
    }
}
