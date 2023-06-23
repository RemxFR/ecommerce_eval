package fr.eval.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_carte_paiement")
@NamedQueries ({
	@NamedQuery(name = "CartePaiement::FindAdressById", query = "FROM CartePaiement cp WHERE id= :id"),
	@NamedQuery(name = "CartePaiement::FindAll", query = "FROM CartePaiement cp")
})
public class CartePaiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nomProprietaire", 
	length = 25)
	private String nomProprietaire;
	
	@Lob
	@Column(name = "numero", 
	columnDefinition = "TINYBLOB")
	private byte[] numero;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateFinValidite")
	private Date dateFinValidite;
	
	@Lob
	@Column(name = "cryptogramme", 
	columnDefinition = "TINYBLOB")
	private byte[] cryptogramme;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "utilisateur_id", 
	referencedColumnName = "id")
	private Utilisateur utilisateur;

	public CartePaiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartePaiement(@NotEmpty String nomProprietaire, @NotEmpty byte[] numero, @NotEmpty Date dateFinValidite,
			byte[] cryptogramme, Utilisateur utilisateur) {
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

	public byte[] getNumero() {
		return numero;
	}

	public void setNumero(byte[] numero) {
		this.numero = numero;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public byte[] getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
