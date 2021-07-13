package br.com.joselucianorc.schoolapi.model.mapper;

import org.modelmapper.ModelMapper;

import br.com.joselucianorc.schoolapi.model.dto.SchoolDto;
import br.com.joselucianorc.schoolapi.model.entity.School;

public class SchoolMapper {

	private ModelMapper modelMapper = new ModelMapper();
	
	public School getEntity(SchoolDto dto) {
		return modelMapper.map(dto, School.class);
	}
	
	public SchoolDto getDto(School school) {
		return modelMapper.map(school, SchoolDto.class);
	}
}
   