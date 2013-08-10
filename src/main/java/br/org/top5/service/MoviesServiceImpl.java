package br.org.top5.service;

import java.util.List;

import br.org.top5.model.Movie;
import br.org.top5.repository.Movies;

public class MoviesServiceImpl implements MoviesService {

	private Movies movies;

	public MoviesServiceImpl(Movies movies) {
		super();
		this.movies = movies;
	}

	public List<Movie> moviesList() {
		return movies.movies();
	}

}
