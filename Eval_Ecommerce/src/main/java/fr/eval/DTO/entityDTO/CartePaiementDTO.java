package fr.eval.DTO.entityDTO;

import java.util.Date;

public class CartePaiementDTO {

	private long id;
	
	private String nomProprietaire;
	
	private String numero;
	
	private String dateFinValidite;
	
	private String cryptogramme;
	
	public CartePaiementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartePaiementDTO(String nomProprietaire, String numero, String dateFinValidite, String cryptogramme) {
		super();
		this.nomProprietaire = nomProprietaire;
		this.numero = numero;
		this.dateFinValidite = dateFinValidite;
		this.cryptogramme = cryptogramme;
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

	public String getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(String dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

}
