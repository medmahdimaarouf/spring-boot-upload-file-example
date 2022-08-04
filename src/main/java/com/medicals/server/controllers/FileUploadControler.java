package com.medicals.server.controllers;

import com.medicals.server.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.medicals.server.core.utils.ResponseFactory;
import com.medicals.server.core.entities.Response;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FileUploadControler {
    @Autowired
    private  StorageService storageService;

    @PostMapping("upload")
    public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            long id = this.storageService.save(file);
            return ResponseFactory.success(id,"Success file uploaded",HttpStatus.OK);
        }catch (Exception exception){
            return  ResponseFactory.error(exception.getMessage(),"Enable to uplaod file",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}