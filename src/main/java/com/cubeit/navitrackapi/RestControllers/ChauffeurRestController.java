package com.cubeit.navitrackapi.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cubeit.navitrackapi.Models.Chauffeur;
import com.cubeit.navitrackapi.Repos.ChauffeurRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cubeIT/NaviTrack/rest/chauffeurs")
@Api(tags ="ChauffeurRestController")
@CrossOrigin("*")
public class ChauffeurRestController {

			
	@Autowired
	private ChauffeurRepository chauffeurRepository;
	
	// http://localhost:1111/api/cubeIT/NaviTrack/rest/chauffeurs/...
	
	//	Swagger UI
	//	http://localhost:1111/swagger-ui/index.html
	
	
	 @ApiOperation(value = "Récuperer la liste des Chauffeurs")
	 @ResponseBody 
	 @GetMapping(path = "/get-all") 
	 public Flux<Chauffeur> getAllChauffeurs() {		
		 	
		return  chauffeurRepository.findAll();
		
	}

	
	@ApiOperation(value = "Récuperer un Chauffeur")
	@ResponseBody 
	@GetMapping(path = "/get-one/{id}")
	public Mono<ResponseEntity<Chauffeur>> getOneChauffeur(@PathVariable String id) {
		    return chauffeurRepository.findById(id)
			.map(chauffeur -> new ResponseEntity<>(chauffeur, HttpStatus.OK))
			.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	 
	

	
	@ApiOperation(value = "Add chauffeur")
	@ResponseBody 
	@PostMapping(path = "/create-one")
  	public Mono<ResponseEntity<Chauffeur>> insertChauffeur(@RequestBody Chauffeur chauffeur){
    return chauffeurRepository.insert(chauffeur)
      .map(chauffeur1 -> new ResponseEntity<>(chauffeur1, HttpStatus.ACCEPTED))
      .defaultIfEmpty(new ResponseEntity<>(chauffeur, HttpStatus.NOT_ACCEPTABLE));
    }


    
	@ApiOperation(value = "Delete chauffeur")
	@ResponseBody 
	@DeleteMapping(path = "/delete/{id}")
	public Mono<Void> deleteChauffeur(@PathVariable String id) {
	  return chauffeurRepository.deleteById(id);
	}


	
	@ApiOperation(value = "Modify chauffeur")
	@ResponseBody
	@PutMapping("/modify-one/{id}")
	public Mono<ResponseEntity<Chauffeur>> updateChauffeur(@RequestBody Chauffeur chauffeur, @PathVariable String id) {
	  return chauffeurRepository.findById(id)
		.flatMap(chauffeur1 -> {
			chauffeur.setId(id);
		  return chauffeurRepository.save(chauffeur)
			.map(chauffeur2 -> new ResponseEntity<>(chauffeur2, HttpStatus.ACCEPTED));
		}).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	
}

