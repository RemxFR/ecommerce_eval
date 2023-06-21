package fr.eval.DTO.entityDTO;

import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.eval.entity.Profil;

public class UtilisateurDTO {

	private long id;

	private String nom;

	private String prenom;

	private String dateNaissance;

	private String profil;

	private String email;

	private String password;

	private String telephone;

	public UtilisateurDTO() {
		super();
	}

	public UtilisateurDTO(String nom, String prenom, String dateNaissance, String profil, String email, String password,
			String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
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

}
