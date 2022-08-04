package com.medicals.server.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

@Service
public class StorageService {

    @Value("${storage-paths-root}")
    private String rootPath;

    public void init() {
        try {
            Files.createDirectory(Paths.get(rootPath));
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public long save(MultipartFile file) {
        long attachmentId = (new Date()).getTime();
        try {
            Files.copy(file.getInputStream(), Paths.get(rootPath).resolve(attachmentId + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.') + 1)));
            return attachmentId;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public void save(MultipartFile file, String path) {
        try {
            Files.copy(file.getInputStream(), Paths.get(rootPath).resolve(path));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }
}
