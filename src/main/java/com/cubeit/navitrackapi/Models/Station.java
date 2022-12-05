package com.cubeit.navitrackapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "stations")
@Data @NoArgsConstructor @AllArgsConstructor
public class Station {
	
	
	@Id
	private String id;
		
	private String client,adresse;
	
	

}
