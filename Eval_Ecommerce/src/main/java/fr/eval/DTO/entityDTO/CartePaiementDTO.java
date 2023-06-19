package fr.eval.DTO.entityDTO;

import java.util.Date;

public class CartePaiementDTO {

	private long id;
	
	private String nomProprietaire;
	
	private String numero;
	
	private Date dateFinValidite;
	
	private String cryptogramme;
	
	private UtilisateurDTO utilisateur;

	public CartePaiementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartePaiementDTO(String nomProprietaire, String numero, Date dateFinValidite, String cryptogramme,
			UtilisateurDTO utilisateur) {
		super();
		this.nomProprietaire = nomProprietaire;
		this.numero = numero;
		this.dateFinValidite = dateFinValidite;
		this.cryptogramme = cryptogramme;
		this.utilisateur = utilisateur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
}
