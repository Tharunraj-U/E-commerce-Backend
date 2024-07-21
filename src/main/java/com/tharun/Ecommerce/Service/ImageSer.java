package com.tharun.Ecommerce.Service;

import com.tharun.Ecommerce.Model.ImageModel;
import com.tharun.Ecommerce.Repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageSer {

    @Autowired
    private ImageRepo imageRepo;

    public void upload(MultipartFile file) throws IOException {
        ImageModel imageModel = new ImageModel();
        imageModel.setName(file.getContentType());
        imageModel.setImage(file.getBytes());
        imageRepo.save(imageModel);
    }
    public Optional<ImageModel> getImage(int id){
        return  imageRepo.findById(id);
    }

    public void deletebyId(int id) {
        imageRepo.deleteById(id);
    }
}
