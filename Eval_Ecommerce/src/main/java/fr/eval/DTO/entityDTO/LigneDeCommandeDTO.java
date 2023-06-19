package fr.eval.DTO.entityDTO;

public class LigneDeCommandeDTO {

	private long id;
	
	private int quantite;
	
	private double prixUnitaire;
	
	private int remiseArticle;
	
	private CommandeDTO commande;
	
	private ArticleDTO articleDTO;

	public LigneDeCommandeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LigneDeCommandeDTO(int quantite, double prixUnitaire, int remiseArticle, CommandeDTO commande,
			ArticleDTO articleDTO) {
		super();
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.articleDTO = articleDTO;
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

	public CommandeDTO getCommande() {
		return commande;
	}

	public void setCommande(CommandeDTO commande) {
		this.commande = commande;
	}

	public ArticleDTO getArticle() {
		return articleDTO;
	}

	public void setArticle(ArticleDTO article) {
		this.articleDTO = article;
	}
	
	
	
}
