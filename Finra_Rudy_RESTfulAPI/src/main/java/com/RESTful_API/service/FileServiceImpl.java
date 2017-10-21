package com.RESTful_API.service;

import com.RESTful_API.dao.FileDataDAO;
import com.RESTful_API.entity.FileMetaData;
import com.RESTful_API.utility.FileUploadUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * Created by lvdiboy on 10/20/17.
 */
@Service
public class FileServiceImpl implements FileService{

    private final FileDataDAO fileDAO;

    @Autowired
    public FileServiceImpl(FileDataDAO fileDAO) {
        this.fileDAO = fileDAO;
    }

    @Override
    @Transactional
    public void saveFile(MultipartFile multipartFile, FileMetaData file) throws IOException {
        FileUploadUtility.saveFile(multipartFile,file);
        fileDAO.save(file);
    }

    @Override
    @Transactional
    public FileMetaData getById(Integer id) {
        FileMetaData file = fileDAO.findOne(id);
        return file;
    }

    @Override
    @Transactional
    public List<FileMetaData> getAllFiles() {
        List<FileMetaData> fList = fileDAO.loadAllFiles();
        return fList;
    }
}
