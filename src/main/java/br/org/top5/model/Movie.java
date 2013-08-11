package br.org.top5.model;

import static javax.persistence.TemporalType.DATE;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "MOVIE")
public class Movie {

	@Id
	@Column(name = "id_movie")
	@TableGenerator(name = "MOVIE_GEN", allocationSize = 1, initialValue = 1, table = "T_ID", pkColumnName = "key", valueColumnName = "valor", pkColumnValue = "ID_MOVIE")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MOVIE_GEN")
	private long id;

	@Column
	private String name;

	@Column
	private String sinopse;

	@Temporal(DATE)
	private Date releaseDate;

	@Column
	private String imdbId;

	@Column
	private String posterName;
	
	@Transient
	private String imdbRating;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "movie")
	private List<Vote> votes;

}
