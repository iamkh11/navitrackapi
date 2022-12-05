package com.cubeit.navitrackapi.Models;

import java.util.List;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "mission")
@Data @NoArgsConstructor @AllArgsConstructor
public class Mission {

	@Id
	private String id;
	
	private String matricule,
					chauffeur,convoyeur,
					date,time,cargo,
					status;
	
	private int weight;
	
    private  List<Station> stations ;

    
}

