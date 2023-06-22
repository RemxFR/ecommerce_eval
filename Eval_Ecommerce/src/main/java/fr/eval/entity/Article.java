package fr.eval.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="article")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "t_article")
@NamedQueries ({
	@NamedQuery(name = "Article::FindAdressById", query = "FROM Article a WHERE id= :id"),
	@NamedQuery(name = "Article::FindAll", query = "FROM Article a")
})
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom", length = 25)
	private String nom;
	
	@Column(name = "prix")
	private double prix;
	
	@Column(name = "remise")
	private int remise;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name = "isVandable")
	private boolean isVendable;
	
	@Column(name = "photos")
	private String photos;
	
	@Column(name = "videos")
	private String videos;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "article",
			fetch = FetchType.EAGER)
	@Column(name = "commentaires")
	private Set<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id", referencedColumnName = "id")
	private Categorie categorie;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Article(String nom, double prix, int remise, int stock, boolean isVendable, String photos, String videos,
			Set<Commentaire> commentaires) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
		this.photos = photos;
		this.videos = videos;
		this.commentaires = commentaires;
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


	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	
	
	
}
