package br.com.joselucianorc.schoolapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.joselucianorc.schoolapi.model.entity.School;
import br.com.joselucianorc.schoolapi.model.repository.SchoolRepository;
import br.com.joselucianorc.schoolapi.service.SchoolService;

@WebMvcTest(SchoolController.class)
public class SchoolControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SchoolService service;
	
	@MockBean
	private SchoolRepository repository;

	private List<School> schools;
	
	@BeforeEach
	public void setup() {
		this.schools = new ArrayList<>();
		this.schools.add(new School(1L, "Sao Paulo School", "saopaulo@brstates.com"));
		this.schools.add(new School(1L, "Rio School", "rio@brstates.com"));
		this.schools.add(new School(1L, "Brasilia School", "brasilia@brstates.com"));
	}
	
	@Test
	public void listSchools() throws Exception {		
		this.mockMvc
			.perform(get("/v1/schools/"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
}
