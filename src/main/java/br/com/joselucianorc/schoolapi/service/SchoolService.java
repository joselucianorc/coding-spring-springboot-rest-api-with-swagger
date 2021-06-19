package br.com.joselucianorc.schoolapi.service;

import java.util.List;

import br.com.joselucianorc.schoolapi.model.entity.School;

public interface SchoolService {
	
	List<School> findAll();
	
	School save(School school);
	
	School getById(Long id);
	
	void delete(Long id);

}
