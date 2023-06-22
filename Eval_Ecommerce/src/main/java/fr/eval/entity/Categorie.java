package fr.eval.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t_categorie")
@NamedQueries ({
	@NamedQuery(name = "Categorie::FindAdressById", query = "FROM Categorie c WHERE id= :id"),
	@NamedQuery(name = "Categorie::FindAll", query = "FROM Categorie c")
})
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom", length = 45)
	private String nom;
	
	@Column(name = "remise")
	private int remise;
	
	@Column(name = "isRemiseCumulable")
	private boolean isRemiseCumulable;
	
	@Column(name = "photo")
	private String photos;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "categorie",
			fetch = FetchType.EAGER)
	private Set<Article> articles;
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Categorie(@NotEmpty String nom, @NotEmpty int remise, @NotEmpty boolean isRemiseCumulable,
			@NotEmpty String photos, Set<Article> articles) {
		super();
		this.nom = nom;
		this.remise = remise;
		this.isRemiseCumulable = isRemiseCumulable;
		this.photos = photos;
		this.articles = articles;
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



	public Set<Article> getArticles() {
		return articles;
	}



	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	
	
	
}
