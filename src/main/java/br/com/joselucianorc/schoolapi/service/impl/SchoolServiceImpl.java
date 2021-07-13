package br.com.joselucianorc.schoolapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.joselucianorc.schoolapi.model.dto.SchoolDto;
import br.com.joselucianorc.schoolapi.model.entity.School;
import br.com.joselucianorc.schoolapi.model.mapper.SchoolMapper;
import br.com.joselucianorc.schoolapi.model.repository.SchoolRepository;
import br.com.joselucianorc.schoolapi.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	private SchoolRepository repository;	
	private SchoolMapper mapper = new SchoolMapper();	
	
	public SchoolServiceImpl(SchoolRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<SchoolDto> findAll() {						
		return repository.findAll().stream().map((School v) -> mapper.getDto(v)).collect(Collectors.toList());
	}

	@Override
	public SchoolDto save(SchoolDto school) {		
		return mapper.getDto(this.repository.save(mapper.getEntity(school)));
	}

	@Override
	public SchoolDto getById(Long id) {
		return mapper.getDto(this.repository.getById(id));
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
