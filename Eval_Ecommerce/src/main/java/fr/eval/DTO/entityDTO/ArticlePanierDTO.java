package fr.eval.DTO.entityDTO;

import fr.eval.entity.Article;

public class ArticlePanierDTO {

	private long id;
	
	private ArticleDTO articleDTO;
	
	private int quantite;
	
	private UtilisateurDTO utilisateur;

	public ArticlePanierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticlePanierDTO(ArticleDTO articleDTO, int quantite, UtilisateurDTO utilisateur) {
		super();
		this.articleDTO = articleDTO;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArticleDTO getArticleDTO() {
		return articleDTO;
	}

	public void setArticleDTO(ArticleDTO articleDTO) {
		this.articleDTO = articleDTO;
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
