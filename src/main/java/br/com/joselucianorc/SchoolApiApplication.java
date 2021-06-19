package br.com.joselucianorc;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.joselucianorc.schoolapi.model.entity.School;
import br.com.joselucianorc.schoolapi.model.repository.SchoolRepository;

@SpringBootApplication
public class SchoolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApiApplication.class, args);
	}
	
    @Bean
    CommandLineRunner init(SchoolRepository schoolRepository) {  
    	
       	schoolRepository.deleteAll();
		School school = new School();   
	    school.setId(1L);
	    school.setName("Contact ");
	    school.setEmail("contact@email.com");                        		             		   
	    school = schoolRepository.saveAndFlush(school);
	    	    
	    LongStream.range(1,1)
        		  .mapToObj(i -> {
        	School  retorno = new School();        	
        	return retorno;
        	
        }).forEach(System.out::println);
		return null;
    }
}
