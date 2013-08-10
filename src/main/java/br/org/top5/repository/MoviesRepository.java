package br.org.top5.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.org.top5.model.Movie;

public class MoviesRepository implements Movies {

	private EntityManager entityManager;

	public MoviesRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> movies() {
		Query query = entityManager.createQuery("from "
				+ this.getClass().getName());
		List<Movie> resultList = query.getResultList();
		return resultList;
	}

}
