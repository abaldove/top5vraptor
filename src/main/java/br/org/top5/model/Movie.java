package br.org.top5.model;

import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5924441323075777616L;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getPosterName() {
		return posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
