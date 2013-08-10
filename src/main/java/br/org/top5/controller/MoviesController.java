package br.org.top5.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.org.top5.model.Movie;
import br.org.top5.service.MoviesService;

@Resource
public class MoviesController {

	private MoviesService moviesService;

	public MoviesController(MoviesService moviesService) {
		super();
		this.moviesService = moviesService;
	}

	public List<Movie> movies() {
		return moviesService.moviesList();
	}

}
