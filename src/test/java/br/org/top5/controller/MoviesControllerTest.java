package br.org.top5.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.org.top5.model.Movie;
import br.org.top5.service.MoviesService;

public class MoviesControllerTest {

	@Mock
	private MoviesService moviesService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMovies() {
		Mockito.when(moviesService.moviesList()).thenReturn(new ArrayList<Movie>());
		MoviesController moviesController = new MoviesController(moviesService);
		List<Movie> movies = moviesController.movies();
		assertNotNull(movies);
		Mockito.verify(moviesService, Mockito.atLeastOnce()).moviesList();
	}

}
