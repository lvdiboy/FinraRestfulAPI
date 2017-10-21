package com.SimpleTest;

import com.RESTful_API.controller.FileController;
import com.RESTful_API.dao.FileDataDAO;
import com.RESTful_API.entity.FileMetaData;
import com.RESTful_API.execption.UploadFailException;
import com.RESTful_API.service.FileService;
import com.RESTful_API.service.FileServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;

/**
 * Created by lvdiboy on 10/20/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class uploadFileTest {

    @Mock
    FileDataDAO fileDataDao;

    @InjectMocks
    FileServiceImpl fileServiceImpl;

    @Mock
    FileService fileService;

    @InjectMocks
    FileController fileController;


    private static FileMetaData fileMetaData=new FileMetaData();

    @Before
    public void init(){
        fileMetaData.setId(1);
        fileMetaData.setName("test");
        fileMetaData.setPath("files/test");
        fileMetaData.setType("txt");
    }

    @Test
    public void findFileByIdServiceTest(){
        when(fileDataDao.findOne(1)).thenReturn(fileMetaData);
        Assert.assertEquals(fileMetaData,fileServiceImpl.getById(1));
    }

    @Test
    public void findAllFilesServiceTest(){
        when(fileDataDao.findAll()).thenReturn(new ArrayList<FileMetaData>(Arrays.asList(fileMetaData)));
        Assert.assertTrue(fileServiceImpl.getAllFiles().size()!=0);
    }

    @Test
    public void findFileByIdControllerTest(){
        when(fileService.getById(1)).thenReturn(fileMetaData);
        Assert.assertEquals(fileMetaData,fileController.getFileById(1));
    }



    @Test(expected = UploadFailException.class)
    public void findFileByIdNotExistTest() throws UploadFailException{
        when(fileService.getById(2)).thenReturn(null);
        fileController.getFileById(2);
    }

    @Test(expected = UploadFailException.class)
    public void findAllFilesNotExistTest() throws UploadFailException{
        when(fileService.getAllFiles()).thenReturn(new ArrayList<FileMetaData>());
        fileController.listUploadedFiles();
    }

}
