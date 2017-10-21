package com.RESTful_API.controller;

import com.RESTful_API.entity.FileMetaData;
import com.RESTful_API.execption.UploadFailException;
import com.RESTful_API.service.FileService;
import com.RESTful_API.utility.FileUploadUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by lvdiboy on 10/20/17.
 */
@Controller
public class FileController {


    private final FileService fileService;
    @Autowired
    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @GetMapping("/files")
    public String listUploadedFiles() throws UploadFailException{
        if(fileService.getAllFiles().isEmpty())
            throw new UploadFailException("There is no file uploaded yet!");
            else
                return fileService.getAllFiles().toString();
    }

    @GetMapping(value = "/files/{id}")
    public String getFileById(@PathVariable("id") Integer id) throws UploadFailException{
        if(fileService.getById(id)==null){
            throw new UploadFailException("There is no such file!");
        }
        else
            return fileService.getById(id).toString();
    }

    @RequestMapping(value = "/upload", method= RequestMethod.POST)
    @ResponseBody
    public FileMetaData uploadFile(@RequestParam (value = "file",required = false) MultipartFile file) throws UploadFailException,IOException{
        if(file == null) throw new UploadFailException("This is an empty file! Please add again!");
        FileMetaData fileMetaData = FileUploadUtility.convertFile(file);
        fileService.saveFile(file,fileMetaData);
        return fileMetaData;
    }


}
