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

import br.com.joselucianorc.schoolapi.exception.ResourceNotFoundException;
import br.com.joselucianorc.schoolapi.model.dto.SchoolDto;
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
		@ApiResponse(code = 200, message = "Schools returned successfully",
		     response = School.class, responseContainer = "List") })
	@GetMapping("/")
	public List<SchoolDto> get() {
		return service.findAll();
	}

	@ApiOperation(value = "post", notes="Create a new school",nickname = "post")
	@ApiResponses(value = {
	   @ApiResponse(code = 500, message = "Server error"),
	   @ApiResponse(code = 201, message = "Created",
	       response = School.class) })
	@PostMapping("/")
	public SchoolDto post(@RequestBody SchoolDto school) {
		return service.save(school);
	}

	@ApiOperation(value = "getById", notes="Get a school by Id", nickname = "getById")
	@ApiResponses(value = {
	   @ApiResponse(code = 500, message = "Server error"),
	   @ApiResponse(code = 200, message = "Success",
	       response = School.class) })
	@GetMapping("{id}")
	public ResponseEntity<SchoolDto> getById(@PathVariable("id") Long id) {
		Optional<SchoolDto> school = Optional.of(service.getById(id));
		if (school.isPresent()) {
			return new ResponseEntity<SchoolDto>(school.get(), HttpStatus.OK); 
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
	public ResponseEntity<SchoolDto> put(@RequestBody SchoolDto school, @PathVariable(value = "id") Long id) {
        Optional<SchoolDto> targetSchool = Optional.of(service.getById(id));
        if (!id.equals(school.getId())) {
        	throw new IllegalStateException("Id param must be equals to school.id");
        }        	
        if(targetSchool.isPresent()) {
        	service.save(school);
        	return new ResponseEntity<SchoolDto>(school, HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }	
	}
	
	@ApiOperation(value = "delete", notes="Delete a school by id", nickname = "delete")
	@ApiResponses(value = {
	    @ApiResponse(code = 500, message = "Server error"),
	    @ApiResponse(code = 200, message = "Success",
	       response = School.class) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<SchoolDto> school = Optional.of(service.getById(id));
        if(school.isPresent()){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            
    }

}