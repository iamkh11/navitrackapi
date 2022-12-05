package com.cubeit.navitrackapi.Repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cubeit.navitrackapi.Models.Chauffeur;

@Repository
public interface ChauffeurRepository  extends ReactiveMongoRepository <Chauffeur, String>  {
    

    
}

