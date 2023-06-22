package fr.eval.DTO.entityDTO;

import java.util.List;

public class UtilisateurDTO {

	private long id;

	private String nom;

	private String prenom;

	private String dateNaissance;

	private String profil;

	private String email;

	private String password;

	private String telephone;

	private List<ArticleDTO> panier;

	private AdressDTO adressDTO;

	public UtilisateurDTO() {
		super();
	}

	public UtilisateurDTO(String nom, String prenom, String dateNaissance, String profil, String email, String password,
			String telephone, List<ArticleDTO> panier, AdressDTO adressDTO) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.panier = panier;
		this.adressDTO = adressDTO;
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public List<ArticleDTO> getPanier() {
		return panier;
	}

	public void setPanier(List<ArticleDTO> panier) {
		this.panier = panier;
	}

	public AdressDTO getAdressDTO() {
		return adressDTO;
	}

	public void setAdressDTO(AdressDTO adressDTO) {
		this.adressDTO = adressDTO;
	}

}
