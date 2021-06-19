package br.com.joselucianorc.schoolapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.joselucianorc.schoolapi.model.entity.School;
import br.com.joselucianorc.schoolapi.model.repository.SchoolRepository;
import br.com.joselucianorc.schoolapi.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	private SchoolRepository repository;
	
	public SchoolServiceImpl(SchoolRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<School> findAll() {
		return repository.findAll();
	}

	@Override
	public School save(School school) {
		return this.repository.save(school);
	}

	@Override
	public School getById(Long id) {
		return this.repository.getById(id);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
