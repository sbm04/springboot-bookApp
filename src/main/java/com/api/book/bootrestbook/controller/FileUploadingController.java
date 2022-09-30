package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadingController {

    @Autowired
    private FileUploadHelper fileUploadHelper;


    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadingFile(@RequestParam("file") MultipartFile file){

//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        System.out.println(file.getContentType());
//        System.out.println(file.getName());

        //validation
        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Requested must contain file");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG content type are allowed");
            }
            //file upload code
             boolean f= fileUploadHelper.uploadFile(file);
            if(f){
                return ResponseEntity.ok("File ia successfully uploaded");

            }
        }
        catch (Exception e){
           e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some went wrong ! Try again");
    }
}
