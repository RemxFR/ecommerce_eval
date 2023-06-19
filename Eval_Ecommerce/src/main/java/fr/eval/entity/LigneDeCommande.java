package fr.eval.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t_ligne_de_commande")
public class LigneDeCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Column(name = "quantite", nullable = false)
	private int quantite;
	
	@NotEmpty
	@Column(name = "prixUnitaire", nullable = false)
	private double prixUnitaire;
	
	@NotEmpty
	@Column(name = "remiseArticle", nullable = false)
	private int remiseArticle;
	
	@ManyToOne
	@JoinColumn(name = "commande_id", nullable = false)
	private Commande commande;
	
	@OneToOne
	@JoinColumn(name = "article_id", referencedColumnName = "id")
	private Article article;

	public LigneDeCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneDeCommande(@NotEmpty int quantite, @NotEmpty double prixUnitaire, @NotEmpty int remiseArticle,
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
