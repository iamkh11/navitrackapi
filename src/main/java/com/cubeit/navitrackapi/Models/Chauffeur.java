package com.cubeit.navitrackapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "chauffeur")
@Data @NoArgsConstructor @AllArgsConstructor
public class Chauffeur {

    @Id
	private String id;
	
	private String full_name,fonction,num_permis;
	
	private Long cin,num_tele;
    
    
}
