package com.cubeit.navitrackapi.Repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cubeit.navitrackapi.Models.Mission;

@Repository
public interface MissionRepository  extends ReactiveMongoRepository <Mission, String>  {
    



    
}

