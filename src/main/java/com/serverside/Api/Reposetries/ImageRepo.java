package com.serverside.Api.Reposetries;


import com.serverside.Api.Model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Images, Integer> {
}
