package fr.eval.DTO.entityDTO;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class UtilisateurDTO {

	private long id;
	
	private String nom;
	
	private String prenom;

	private Date dateNaissance;
	
	private boolean isActif;
	
	private ProfilDTO profil;
	
	private String email;
	
	private String password;
	
	private String telephone;
	
	private AdressDTO adresse;
	
	private Set<CommandeDTO> commandes;
	
	private Set<CartePaiementDTO> cartePaiements;
	
	private List<CommentaireDTO> commentaires;
	
	private Set<ArticlePanierDTO> panier;

	public UtilisateurDTO() {
		super();
	}


	public UtilisateurDTO(String nom, String prenom, Date dateNaissance, boolean isActif, ProfilDTO profil,
			String email, String password, String telephone, AdressDTO adresse, Set<CommandeDTO> commandes,
			Set<CartePaiementDTO> cartePaiements, List<CommentaireDTO> commentaires, Set<ArticlePanierDTO> panier) {
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

	public ProfilDTO getProfil() {
		return profil;
	}

	public void setProfil(ProfilDTO profil) {
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public AdressDTO getAdresse() {
		return adresse;
	}

	public void setAdresse(AdressDTO adresse) {
		this.adresse = adresse;
	}

	public Set<CommandeDTO> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<CommandeDTO> commandes) {
		this.commandes = commandes;
	}

	public Set<CartePaiementDTO> getCartePaiements() {
		return cartePaiements;
	}

	public void setCartePaiements(Set<CartePaiementDTO> cartePaiements) {
		this.cartePaiements = cartePaiements;
	}

	public List<CommentaireDTO> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<CommentaireDTO> commentaires) {
		this.commentaires = commentaires;
	}

	public Set<ArticlePanierDTO> getPanier() {
		return panier;
	}

	public void setPanier(Set<ArticlePanierDTO> panier) {
		this.panier = panier;
	}
	
	
}
