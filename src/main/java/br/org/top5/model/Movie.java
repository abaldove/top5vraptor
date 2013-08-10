package br.org.top5.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

import lombok.Data;

@Data
@Entity
public class Movie {
	
	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String sinopse;
	
	private Date releaseDate;
	
	@Column
	private String imdbId;
	
	@Column
	private String posterName;
	

}
