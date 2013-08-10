package br.org.top5.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.org.top5.model.Movie;

public class MoviesRepositoryTest {

	@Test
	public void testMovies() {
		Movies movies = new MoviesRepository();
		List<Movie> moviesList = movies.movies();
		assertNotNull(moviesList);

	}

}
