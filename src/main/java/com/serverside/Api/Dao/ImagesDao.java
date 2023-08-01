package com.serverside.Api.Dao;


import com.serverside.Api.Model.Images;
import com.serverside.Api.Reposetries.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImagesDao {

    @Autowired
    ImageRepo imageRepo;

    public void addI(Images i){

        imageRepo.save(i) ;


    }

    public Images getI(Integer id){

        return imageRepo.findById(id).get();
    }





}
