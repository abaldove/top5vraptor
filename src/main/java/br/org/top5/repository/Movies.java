package br.org.top5.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.org.top5.model.Movie;

@Repository
public interface Movies {
	
	public List<Movie> movies();

}
