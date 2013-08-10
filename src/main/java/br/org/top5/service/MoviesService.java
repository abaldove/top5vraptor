package br.org.top5.service;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.org.top5.model.Movie;

@Component
public interface MoviesService {

	public List<Movie> moviesList();
}
