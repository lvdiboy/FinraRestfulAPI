package com.RESTful_API.service;

import com.RESTful_API.entity.FileMetaData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by lvdiboy on 10/20/17.
 */
public interface FileService {
    public void saveFile(MultipartFile multipartFile, FileMetaData file) throws IOException;

    public FileMetaData getById(Integer id);

    public List<FileMetaData> getAllFiles();
}
