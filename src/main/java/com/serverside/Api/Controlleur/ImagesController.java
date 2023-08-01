package com.serverside.Api.Controlleur;


import com.serverside.Api.Dao.ImagesDao;
import com.serverside.Api.Model.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ImagesController {


    @Autowired
    ImagesDao imagesDao;

    @PostMapping("/image/post")
    public void addImage(@RequestBody Images i){

        imagesDao.addI(i);


    }

    @GetMapping ("/image/getOne/{id}")
    public Images getImage(@PathVariable int i){

     return    imagesDao.getI(i);


    }
}
