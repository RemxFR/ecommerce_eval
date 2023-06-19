package fr.eval.DTO.entityDTO;

import java.util.Set;

public class ArticleDTO {

	private long id;
	
	private String nom;
	
	private double prix;
	
	private int remise;
	
	private int stock;
	
	private boolean isVendable;
	
	private String photos;
	
	private String videos;
	
	private Set<CommentaireDTO> commentaires;
	
	private CategorieDTO categorie;
	
	public ArticleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleDTO(String nom, double prix, int remise, int stock, boolean isVendable, String photos, String videos,
			Set<CommentaireDTO> commentaires, CategorieDTO categorie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
		this.photos = photos;
		this.videos = videos;
		this.commentaires = commentaires;
		this.categorie = categorie;
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isVendable() {
		return isVendable;
	}

	public void setVendable(boolean isVendable) {
		this.isVendable = isVendable;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}

	public Set<CommentaireDTO> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<CommentaireDTO> commentaires) {
		this.commentaires = commentaires;
	}

	public CategorieDTO getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieDTO categorie) {
		this.categorie = categorie;
	}


}
