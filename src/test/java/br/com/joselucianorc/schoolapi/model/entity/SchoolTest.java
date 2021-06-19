package br.com.joselucianorc.schoolapi.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SchoolTest {
	
	@Test
	public void whenSchoolIsInstantiated() {
		final Long id = 1L;
		final String name = "Brilliant School";
		final String email = "brilliant@brstates.com.br";
		final School school = new School(id, name, email);
		
		Long idObtained = school.getId();
		String nameObtained = school.getName();
		String emailObtained = school.getEmail();
		
		assertEquals(idObtained, id);
		assertEquals(nameObtained, name);
		assertEquals(emailObtained, email);		
		
	}
}
