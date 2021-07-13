package br.com.joselucianorc.schoolapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolDto {
	private Long id;
	private String name;
	private String email;
	
}
