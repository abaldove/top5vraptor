package br.org.top5.repository;

import java.util.ArrayList;
import java.util.List;

import br.org.top5.model.Movie;

public class MoviesRepository implements Movies {

	public List<Movie> movies() {
		return new ArrayList<Movie>();
	}

}
