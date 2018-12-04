package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.File;

import java.util.List;

public interface FileService {
    void deleteFile(int id);
    void saveFile(File file);
    File getFile(int id);
    List<File> getFiles();
}
