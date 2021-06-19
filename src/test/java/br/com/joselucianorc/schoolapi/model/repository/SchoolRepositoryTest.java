package br.com.joselucianorc.schoolapi.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.joselucianorc.schoolapi.model.entity.School;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class SchoolRepositoryTest {
	
	@Autowired
	private SchoolRepository repository;

	@Test
	public void whenSavingSchool() {
		School school = new School(1L, "Sao Paulo School", "saopaulo@brstates.com");
		School expected = repository.save(school);
		
		Optional<School> read = repository.findById(1L);
		
		assertTrue(read.isPresent());		
		assertEquals(read.get().getId(), expected.getId());
	}

}
