package fr.eval.DTO.entityDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

public class CommentaireDTO {

	private long id;
	
	private String texte;
	
	private int note;
	
	private ArticleDTO article;
	
	private UtilisateurDTO utilisateurDTO;

	public CommentaireDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public CommentaireDTO(String texte, int note, ArticleDTO article, UtilisateurDTO utilisateurDTO) {
		super();
		this.texte = texte;
		this.note = note;
		this.article = article;
		this.utilisateurDTO = utilisateurDTO;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public ArticleDTO getArticle() {
		return article;
	}

	public void setArticle(ArticleDTO article) {
		this.article = article;
	}

	public UtilisateurDTO getUtilisateur() {
		return utilisateurDTO;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateurDTO = utilisateur;
	}
	
}
