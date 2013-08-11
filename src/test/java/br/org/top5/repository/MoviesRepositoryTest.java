package br.org.top5.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.reflectionassert.ReflectionAssert;

import br.org.top5.model.Movie;

@DataSet("Movie.xml")
@Transactional(TransactionMode.DISABLED)
@JpaEntityManagerFactory(persistenceUnit = "testPersistenceUnit")
public class MoviesRepositoryTest extends UnitilsJUnit4 {

	private Movies moviesRepository;
	static EntityManagerFactory emf;
	EntityManager entityManager;

	@BeforeClass
	public static void setUpClass() {
		emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
	}

	@Before
	public void setUp() {
		entityManager = emf.createEntityManager();
		moviesRepository = new MoviesRepository(entityManager);

	}

	@Test
	public void testMoviesFull() {
		List<Movie> moviesList = moviesRepository.movies();
		assertNotNull(moviesList);
		ReflectionAssert.assertPropertyLenientEquals("name",
				Arrays.asList("Super Man", "Wolverine"), moviesList);
		ReflectionAssert.assertPropertyLenientEquals("id",
				Arrays.asList(1l, 2l), moviesList);
		Assert.assertEquals(moviesList.get(0).getVotes().size(),3);
		Assert.assertEquals(moviesList.get(1).getVotes().size(),2);
	}

}
