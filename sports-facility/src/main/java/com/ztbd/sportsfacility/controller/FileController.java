package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.File;
import com.ztbd.sportsfacility.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/files")
    public List<File> getFiles() {
        return fileService.getFiles();
    }

    @GetMapping("/files/{fileId}")
    public File getFile(@PathVariable int fileId) {
        return fileService.getFile(fileId);
    }

    @PostMapping("/files")
    public File addFile(@ModelAttribute File file) {
        fileService.saveFile(file);
        return file;
    }

    @PutMapping("/files")
    public File updateFile(@RequestBody File file) {
        fileService.saveFile(file);
        return file;
    }

    @DeleteMapping("/files/{fileId}")
    public void deleteFile(@PathVariable int fileId) {
        fileService.deleteFile(fileId);
    }
}
