package fr.eval.entity;

import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "t_utilisateur")
@NamedQueries ({
	@NamedQuery(name = "Utilisateur::FindUtilisateurById", query = "FROM Utilisateur u WHERE id= :id"),
	@NamedQuery(name = "Utilisateur::FindUtilisateursByMail", query = "FROM Utilisateur u WHERE mail= :mail"),
	@NamedQuery(name = "Utilisateur::FindAll", query = "FROM Utilisateur u")
})
@XmlRootElement(name = "utilisateur")
@XmlAccessorType(XmlAccessType.FIELD)
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom", length = 25)
	private String nom;
	
	@Column(name = "prenom", length = 25)
	private String prenom;
	
	
	@Column(name = "dateNaissance")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Column(name = "isActif", columnDefinition = "BOOLEAN")
	private boolean isActif;
	
	@Column(name = "profil")
	private String profil;
	
	@Column(name = "mail", length = 25)
	private String email;
	
	@Column(name = "mdp", columnDefinition = "TINYBLOB")
	@Lob
	private byte[] password;
	
	@Column(name = "telephone", length = 10)
	private String telephone;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur")
	@JoinColumn(name = "adresse_id", referencedColumnName = "id")
	private Adress adresse;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "utilisateur",
			fetch = FetchType.EAGER)
	private Set<Commande> commandes;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "utilisateur",
			fetch = FetchType.EAGER)
	private Set<CartePaiement> cartePaiements;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "utilisateur",
			fetch = FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "utilisateur", 
			fetch = FetchType.EAGER)
	private Set<ArticlePanier> panier;

	public Utilisateur() {
		super();
	}

	public Utilisateur(@NotEmpty String nom, @NotEmpty String prenom, @NotEmpty Date dateNaissance,
			@NotEmpty boolean isActif, @NotEmpty String profil, @NotEmpty String email, byte[] password,
			@NotEmpty String telephone, Adress adresse, Set<Commande> commandes, Set<CartePaiement> cartePaiements,
			List<Commentaire> commentaires, Set<ArticlePanier> panier) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.adresse = adresse;
		this.commandes = commandes;
		this.cartePaiements = cartePaiements;
		this.commentaires = commentaires;
		this.panier = panier;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adress getAdresse() {
		return adresse;
	}

	public void setAdresse(Adress adresse) {
		this.adresse = adresse;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Set<CartePaiement> getCartePaiements() {
		return cartePaiements;
	}

	public void setCartePaiements(Set<CartePaiement> cartePaiements) {
		this.cartePaiements = cartePaiements;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Set<ArticlePanier> getPanier() {
		return panier;
	}

	public void setPanier(Set<ArticlePanier> panier) {
		this.panier = panier;
	}
	
	
}
