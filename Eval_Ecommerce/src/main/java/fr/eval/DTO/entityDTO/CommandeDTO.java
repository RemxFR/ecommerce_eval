package fr.eval.DTO.entityDTO;

import java.util.Date;
import java.util.List;

public class CommandeDTO {

	private long id;
	
	private String numero;
	
	private Date dateCreation;
	
	private Date dateLivraison;
	
	private int totalRemise;
	
	private double fraisExpedition;
	
	private double totalGeneral;
	
	private AdressDTO adresseFacturation;
	
	private AdressDTO adresseLivraison;
	
	private CartePaiementDTO cpDefaut;
	
	private UtilisateurDTO utilisateur;
	
	private List<LigneDeCommandeDTO> lignesCommande;

	public CommandeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandeDTO(String numero, Date dateCreation, Date dateLivraison, int totalRemise, double fraisExpedition,
			double totalGeneral, AdressDTO adresseFacturation, AdressDTO adresseLivraison, CartePaiementDTO cpDefaut,
			UtilisateurDTO utilisateur, List<LigneDeCommandeDTO> lignesCommande) {
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

	public AdressDTO getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(AdressDTO adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public AdressDTO getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(AdressDTO adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public CartePaiementDTO getCpDefaut() {
		return cpDefaut;
	}

	public void setCpDefaut(CartePaiementDTO cpDefaut) {
		this.cpDefaut = cpDefaut;
	}

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<LigneDeCommandeDTO> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneDeCommandeDTO> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}
	
}
