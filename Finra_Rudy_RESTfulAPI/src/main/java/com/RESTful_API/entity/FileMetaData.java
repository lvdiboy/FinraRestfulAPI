package com.RESTful_API.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by lvdiboy on 10/20/17.
 */
@Entity
@Table(name = "File_Data")
public class FileMetaData {
    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "file_name")
    private String name;

    @Column(name = "file_type")
    private String type;

    @Column(name ="file_path")
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileMetaData{" +
                "id=" + id +
                ", fileName='" + name + '\'' +
                ", fileType='" + type + '\'' +
                ", fileLocation='" + path + '\'' +
                '}';
    }

}
