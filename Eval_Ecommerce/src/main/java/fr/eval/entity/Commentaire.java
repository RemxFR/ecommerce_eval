package fr.eval.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t_commentaire")
@NamedQueries ({
	@NamedQuery(name = "Commentaire::FindAdressById", query = "FROM Commentaire c WHERE id= :id"),
	@NamedQuery(name = "Commentaire::FindAll", query = "FROM Commentaire c")
})
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Column(name = "texte", nullable = false)
	private String texte;
	
	@Column(name = "note", nullable = false)
	private int note;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false)
	private Article article;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
	private Utilisateur utilisateur;

	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commentaire(@NotEmpty String texte, @NotEmpty int note, @NotEmpty Article article,
			@NotEmpty Utilisateur utilisateur) {
		super();
		this.texte = texte;
		this.note = note;
		this.article = article;
		this.utilisateur = utilisateur;
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

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
