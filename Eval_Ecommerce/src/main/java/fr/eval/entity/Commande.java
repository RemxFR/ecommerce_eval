package fr.eval.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t_commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Column(name = "numero", length = 10, nullable = false, updatable = false)
	private String numero;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateCreation", nullable = false, updatable = false)
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateLivraison", nullable = false, updatable = false)
	private Date dateLivraison;
	
	@NotEmpty
	@Column(name = "totalRemise", nullable = false)
	private int totalRemise;
	
	@NotEmpty
	@Column(name = "fraisExpidition", nullable = false)
	private double fraisExpedition;
	
	@NotEmpty
	@Column(name = "totalGeneral", nullable = false, updatable = false)
	private double totalGeneral;
	
	@NotEmpty
	@OneToOne
	private Adress adresseFacturation;
	
	@NotEmpty
	@OneToOne
	private Adress adresseLivraison;
	
	@NotEmpty
	@OneToOne
	private CartePaiement cpDefaut;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "utilisateur_id", referencedColumnName = "id", nullable = false)
	private Utilisateur utilisateur;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "commande", 
			fetch = FetchType.EAGER)
	private List<LigneDeCommande> lignesCommande;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(@NotEmpty String numero, Date dateCreation, Date dateLivraison, @NotEmpty int totalRemise,
			@NotEmpty double fraisExpedition, @NotEmpty double totalGeneral, @NotEmpty Adress adresseFacturation,
			@NotEmpty Adress adresseLivraison, @NotEmpty CartePaiement cpDefaut, Utilisateur utilisateur,
			List<LigneDeCommande> lignesCommande) {
		super();
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraisExpedition = fraisExpedition;
		this.totalGeneral = totalGeneral;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
		this.cpDefaut = cpDefaut;
		this.utilisateur = utilisateur;
		this.lignesCommande = lignesCommande;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public int getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(int totalRemise) {
		this.totalRemise = totalRemise;
	}

	public double getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(double fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public double getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(double totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public Adress getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adress adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Adress getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adress adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public CartePaiement getCpDefaut() {
		return cpDefaut;
	}

	public void setCpDefaut(CartePaiement cpDefaut) {
		this.cpDefaut = cpDefaut;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<LigneDeCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneDeCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}
	
}
