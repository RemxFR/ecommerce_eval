package fr.eval.DTO.entityDTO;

import java.util.Set;

public class CategorieDTO {

	private long id;
	
	private String nom;
	
	private int remise;
	
	private boolean isRemiseCumulable;
	
	private String photos;
	
	private Set<ArticleDTO> articlesDto;
	
	public CategorieDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CategorieDTO(String nom, int remise, boolean isRemiseCumulable,
			String photos, Set<ArticleDTO> articlesDto) {
		super();
		this.nom = nom;
		this.remise = remise;
		this.isRemiseCumulable = isRemiseCumulable;
		this.photos = photos;
		this.articlesDto = articlesDto;
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



	public int getRemise() {
		return remise;
	}



	public void setRemise(int remise) {
		this.remise = remise;
	}



	public boolean isRemiseCumulable() {
		return isRemiseCumulable;
	}



	public void setRemiseCumulable(boolean isRemiseCumulable) {
		this.isRemiseCumulable = isRemiseCumulable;
	}



	public String getPhotos() {
		return photos;
	}



	public void setPhotos(String photos) {
		this.photos = photos;
	}



	public Set<ArticleDTO> getArticles() {
		return articlesDto;
	}



	public void setArticles(Set<ArticleDTO> articles) {
		this.articlesDto = articles;
	}
	
	
	
}
