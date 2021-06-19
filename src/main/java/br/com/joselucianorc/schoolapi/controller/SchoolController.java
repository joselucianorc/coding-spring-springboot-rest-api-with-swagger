package br.com.joselucianorc.schoolapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joselucianorc.schoolapi.model.entity.School;
import br.com.joselucianorc.schoolapi.service.SchoolService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("v1/schools")
public class SchoolController {

	private SchoolService service;
	
	private SchoolController(SchoolService service) {
		this.service = service;
	}
	
	@ApiOperation(value = "get", notes="List all schools",nickname = "get")
	@ApiResponses(value = {
		@ApiResponse(code = 500, message = "Server error"),
		@ApiResponse(code = 200, message = "Successful schools retrieval",
		     response = School.class, responseContainer = "List") })
	@GetMapping("/")
	public List<School> get() {
		return service.findAll();
	}

	@ApiOperation(value = "post", notes="Create a new school",nickname = "post")
	@ApiResponses(value = {
	   @ApiResponse(code = 500, message = "Server error"),
	   @ApiResponse(code = 201, message = "Created",
	       response = School.class) })
	@PostMapping("/")
	public School post(@RequestBody School school) {
		return service.save(school);
	}

	@ApiOperation(value = "getById", notes="Create a new school", nickname = "getById")
	@ApiResponses(value = {
	   @ApiResponse(code = 500, message = "Server error"),
	   @ApiResponse(code = 200, message = "Success",
	       response = School.class) })
	@GetMapping("{id}")
	public ResponseEntity<School> getById(@PathVariable("id") Long id) {
		Optional<School> school = Optional.of(service.getById(id));
		if (school.isPresent()) {
			return new ResponseEntity<School>(school.get(), HttpStatus.OK); 
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "put", notes="Update a school", nickname = "put")
	@ApiResponses(value = {
	   @ApiResponse(code = 500, message = "Server error"),
	   @ApiResponse(code = 200, message = "Success",
	      response = School.class) })
	@PutMapping("/{id}")
	public ResponseEntity<School> put(@RequestBody School school, @PathVariable(value = "id") Long id) {
        Optional<School> targetSchool = Optional.of(service.getById(id));
        if(targetSchool.isPresent()) {
        	service.save(school);
        	return new ResponseEntity<School>(school, HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }	
	}
	
	@ApiOperation(value = "delete", notes="Delete a school", nickname = "delete")
	@ApiResponses(value = {
	    @ApiResponse(code = 500, message = "Server error"),
	    @ApiResponse(code = 200, message = "Success",
	       response = School.class) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        Optional<School> school = Optional.of(service.getById(id));
        if(school.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}