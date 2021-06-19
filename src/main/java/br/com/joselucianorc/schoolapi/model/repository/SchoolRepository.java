package br.com.joselucianorc.schoolapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joselucianorc.schoolapi.model.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

}
