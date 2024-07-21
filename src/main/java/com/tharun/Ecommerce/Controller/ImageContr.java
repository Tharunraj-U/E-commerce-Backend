package com.tharun.Ecommerce.Controller;

import com.tharun.Ecommerce.Model.ImageModel;
import com.tharun.Ecommerce.Service.ImageSer;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*")
public class ImageContr {

    @Autowired
    private ImageSer imageSer;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestParam MultipartFile file) {
        try {
            imageSer.upload(file);
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        } catch (IOException exception) {
            return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get/{id}")
           public ResponseEntity<byte[]> getImage(@PathVariable("id") int id){
        Optional<ImageModel> imageModel=imageSer.getImage(id);
        if(imageModel.isPresent()){
            ImageModel imageModel1=imageModel.get();
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE,imageModel1.getName()).body(imageModel1.getImage());
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> Delete(@PathVariable("id") int id){
        imageSer.deletebyId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
