package fr.eval.DTO.entityDTO;

import fr.eval.entity.Article;

public class ArticlePanierDTO {

	private long id;
	
	private Article article;
	
	private int quantite;
	
	private UtilisateurDTO utilisateur;

	public ArticlePanierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticlePanierDTO(Article article, int quantite, UtilisateurDTO utilisateur) {
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

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
