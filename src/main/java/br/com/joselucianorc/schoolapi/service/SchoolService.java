package br.com.joselucianorc.schoolapi.service;

import java.util.List;

import br.com.joselucianorc.schoolapi.model.dto.SchoolDto;

public interface SchoolService {
	
	List<SchoolDto> findAll();
	
	SchoolDto save(SchoolDto school);
	
	SchoolDto getById(Long id);
	
	void delete(Long id);

}
