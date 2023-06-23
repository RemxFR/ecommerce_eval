package fr.eval.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_ligne_de_commande")
@NamedQueries ({
	@NamedQuery(name = "LigneDeCommande::FindAdressById", query = "FROM LigneDeCommande l WHERE id= :id"),
	@NamedQuery(name = "LigneDeCommande::FindAll", query = "FROM LigneDeCommande l")
})
public class LigneDeCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "quantite")
	private int quantite;
	
	@Column(name = "prixUnitaire")
	private double prixUnitaire;
	
	@Column(name = "remiseArticle")
	private int remiseArticle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "commande_id")
	private Commande commande;
	
	@OneToOne
	@JoinColumn(name = "article_id", referencedColumnName = "id")
	private Article article;

	public LigneDeCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneDeCommande(int quantite, double prixUnitaire, int remiseArticle,
			Commande commande, Article article) {
		super();
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.article = article;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(int remiseArticle) {
		this.remiseArticle = remiseArticle;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
}
