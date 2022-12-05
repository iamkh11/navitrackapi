package com.cubeit.navitrackapi.RestControllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cubeit.navitrackapi.Models.Mission;
import com.cubeit.navitrackapi.Repos.MissionRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cubeIT/NaviTrack/rest/missions")
@Api(tags ="MissionRestController")
public class MissionRestController {
    @Autowired
    private MissionRepository missionRepository;

    // http://localhost:1111/api/cubeIT/NaviTrack/rest/missions/...
	
	//	Swagger UI
	//	http://localhost:1111/swagger-ui/index.html

   
	 @ApiOperation(value = "Récuperer la liste des missions")
	 @ResponseBody 
	 @GetMapping(path = "/get-all") 
	public Flux<Mission> getAllMissions() {		
		 	
		return  missionRepository.findAll();
		
	}

	
	@ResponseBody 
	@ApiOperation(value = "Récuperer mission")
	@GetMapping(path = "/get-one/{id}")
	public Mono<ResponseEntity<Mission>> getOneMission(@PathVariable String id) {
		    return missionRepository.findById(id)
			.map(mission -> new ResponseEntity<>(mission, HttpStatus.OK))
			.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	
	@ApiOperation(value = "add mission")
	@ResponseBody 
	@PostMapping(path = "/create-one")
  	public Mono<ResponseEntity<Mission>> insertMission(@RequestBody Mission mission){
    return missionRepository.insert(mission)
      .map(mission1 -> new ResponseEntity<>(mission1, HttpStatus.ACCEPTED))
      .defaultIfEmpty(new ResponseEntity<>(mission, HttpStatus.NOT_ACCEPTABLE));
    }

	 
	 @ApiOperation(value = "delete mission")
	 @ResponseBody 
	 @DeleteMapping(path = "/delete/{id}")
	 public Mono<Void> deleteMission(@PathVariable String id) {
	   return missionRepository.deleteById(id);
	}

	
	@ApiOperation(value = "modify mission")
	@ResponseBody 
	@PutMapping("/modify-one/{id}")
	public Mono<ResponseEntity<Mission>> updateMission(@RequestBody Mission mission, @PathVariable String id) {
	  return missionRepository.findById(id)
		.flatMap(mission1 -> {
			mission.setId(id);
		  return missionRepository.save(mission)
			.map(mission2 -> new ResponseEntity<>(mission2, HttpStatus.ACCEPTED));
		}).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}






}
