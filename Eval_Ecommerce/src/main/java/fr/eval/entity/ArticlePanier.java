package fr.eval.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_article_panier")
@NamedQueries ({
	@NamedQuery(name = "ArticlePanier::FindArticleById", query = "FROM ArticlePanier ap WHERE id= :id"),
	@NamedQuery(name = "ArticlePanier::FindAll", query = "FROM ArticlePanier ap"),
	@NamedQuery(name = "ArticlePanier::FindPanierByClientId", query = "FROM ArticlePanier ap WHERE utilisateur_id = :id")
})
public class ArticlePanier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "article_id", referencedColumnName = "id")
	private Article article;
	
	@Column(name = "quantite")
	private int quantite;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
	private Utilisateur utilisateur;

	public ArticlePanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticlePanier(Article article, int quantite, Utilisateur utilisateur) {
		super();
		this.article = article;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
