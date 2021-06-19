package br.com.joselucianorc.schoolapi.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.joselucianorc.schoolapi.model.entity.School;
import br.com.joselucianorc.schoolapi.model.repository.SchoolRepository;

@ExtendWith(MockitoExtension.class)
public class SchoolServiceImplTest {
	
	@Mock
	private SchoolRepository schoolRepository;
	
	@InjectMocks
	private SchoolServiceImpl schoolService;
	
	private List<School> schools;
	
	@BeforeEach
	public void setup() {
		this.schools = new ArrayList<>();
		this.schools.add(new School(1L, "Sao Paulo School", "saopaulo@brstates.com"));
		this.schools.add(new School(1L, "Rio School", "rio@brstates.com"));
		this.schools.add(new School(1L, "Brasilia School", "brasilia@brstates.com"));
	}
	
	@AfterEach
	public void cleanUp() {
		this.schools.clear();
	}
	
	@Test
	public void whenListingSchools() {
		when(schoolRepository.findAll()).thenReturn(schools);
		List<School> expected = schoolService.findAll();
		assertEquals(expected, schools);
	}
	
	@Test
	public void whenSchoolIsFoundById() {
		final Long id = 1L;
		final School school = new School(1L, "Uberlandia School", "uberlandia@brstates.com");
				
		when(schoolRepository.getById(id)).thenReturn(school);
		School receivedSchool = schoolService.getById(id);
		assertNotNull(receivedSchool);		
	}
	
	@Test
	public void whenSchoolIsRemoved() {
		final Long id = 1L;
		schoolService.delete(id);
		schoolService.delete(id);
		verify(schoolRepository, times(2)).deleteById(id);
	}
	
	@Test
	public void whenSchoolIsUpdated() {
		final School school = new School(1L, "Uberlandia School", "uberlandia@brstates.com");
		school.setId(1L);
		when(schoolRepository.save(school)).thenReturn(school);
		
		final School expected = schoolService.save(school);
		assertNotNull(expected);
		verify(schoolRepository).save(Mockito.any(School.class));
	}
	
	@Test
	public void whenSchoolIsCreated() {
		final School school = new School(10L, "Aracaju School", "aracaju@brstates.com.br");
		when(schoolRepository.save(school)).thenReturn(school);
		
		School expected = schoolService.save(school);
		assertNotNull(expected);
		
		assertEquals(10L, (Long)expected.getId());		
	}
}
