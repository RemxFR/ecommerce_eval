package fr.eval.DTO.entityDTO;

import java.util.Set;

public class ArticleDTO {

	private long id;

	private String nom;

	private String description;

	private String photos;

	public ArticleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleDTO(String nom, String description, String photos) {
		super();
		this.nom = nom;
		this.description = description;
		this.photos = photos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	
	
}
