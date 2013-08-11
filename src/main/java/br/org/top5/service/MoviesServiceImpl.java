package br.org.top5.service;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import lombok.extern.log4j.Log4j;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import br.org.top5.model.Movie;
import br.org.top5.repository.Movies;

@Log4j
public class MoviesServiceImpl implements MoviesService {

	private static final String RETY_URL_KEY = "rety.url";
	private static final String N_A = "N/A";
	private static final String RATING = "rating";
	private Movies movies;
	private Properties properties;
	private String retyUrl;
	{
		properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream(
					"top5.properties"));
		} catch (IOException e) {
			log.error("Erro carregando o arquivo top.properties", e);
		}
		retyUrl = properties.getProperty(RETY_URL_KEY);
	}

	public MoviesServiceImpl(Movies movies) {
		super();
		this.movies = movies;
	}

	public List<Movie> moviesList() {
		List<Movie> moviesList = movies.movies();
		for (Movie movie : moviesList) {
			imdbRating(movie);
		}
		return moviesList;
	}

	private void imdbRating(Movie movie) {
		Resty r = new Resty();
		String rating;
		try {
			JSONResource resource = r.json(retyUrl + movie.getImdbId());
			rating = (String) resource.get(RATING);
		} catch (Exception e) {
			rating = N_A;
			log.error(
					"Erro consultando o serviço http://deanclatworthy.com para condultar o IMDB rating",
					e);
		}

		movie.setImdbRating(rating);

	}

}
