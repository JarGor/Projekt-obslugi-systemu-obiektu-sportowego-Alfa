package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.FileRepository;
import com.ztbd.sportsfacility.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private static final String UPLOAD_FOLDER =
            "C:\\Users\\M\\Desktop\\Bazy Danych\\sports-facility\\src\\main\\resources\\static\\files\\";

    @Autowired
    private FileRepository fileRepository;

    @Override
    public void deleteFile(int id) {
        File file = getFile(id);
        if(file != null) {
            java.io.File diskFile = new java.io.File(file.getPath());
            diskFile.delete();
        }
        fileRepository.deleteById(id);
    }

    @Override
    public void saveFile(File file) {
        if (!file.getMultipartFile().isEmpty()) {
            try {
                UUID uuid = UUID.randomUUID();
                file.setName(uuid.toString());
                file.setSize((int) file.getMultipartFile().getSize());
                file.setOriginalName(file.getMultipartFile().getOriginalFilename());
                byte[] bytes = file.getMultipartFile().getBytes();
                Path path = Paths.get(UPLOAD_FOLDER + file.getName());
                file.setPath(path.toString());
                file.setContentType(file.getMultipartFile().getContentType());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileRepository.save(file);
        }
    }

    @Override
    public File getFile(int id) {
        return fileRepository.findById(id).orElse(null);
    }

    @Override
    public List<File> getFiles() {
        List<File> files = new ArrayList<>();
        fileRepository.findAll().forEach(e -> files.add(e));
        return files;
    }
}
