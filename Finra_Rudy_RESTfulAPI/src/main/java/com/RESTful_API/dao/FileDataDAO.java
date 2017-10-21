package com.RESTful_API.dao;

import com.RESTful_API.entity.FileMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lvdiboy on 10/20/17.
 */
@Repository
public interface FileDataDAO extends JpaRepository<FileMetaData,Integer>{


    @Query("select distinct object (f) from FileMetaData f")
    List<FileMetaData> loadAllFiles();

}
