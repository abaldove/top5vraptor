package br.org.top5.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.org.top5.model.Movie;

public class MoviesServiceTest {
	

	@Test
	public void testMoviesList() {
		MoviesService movies = new MoviesServiceImpl();		
		List<Movie> moviesList = movies.moviesList();
		
		assertNotNull(moviesList);
	}

}
