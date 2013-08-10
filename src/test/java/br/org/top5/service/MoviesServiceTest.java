package br.org.top5.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.org.top5.model.Movie;
import br.org.top5.repository.Movies;

public class MoviesServiceTest {
	
	@Mock
	private Movies movies;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMoviesList() {
		Mockito.when(movies.movies()).thenReturn(new ArrayList<Movie>());
		MoviesService moviesService = new MoviesServiceImpl(movies);		
		List<Movie> moviesList = moviesService.moviesList();		
		assertNotNull(moviesList);
	}

}
