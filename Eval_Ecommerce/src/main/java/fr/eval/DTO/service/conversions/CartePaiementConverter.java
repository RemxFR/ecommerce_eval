package fr.eval.DTO.service.conversions;

import fr.eval.DTO.entityDTO.CartePaiementDTO;
import fr.eval.DTO.service.ChiffrageUtilisateurEtCp;
import fr.eval.entity.CartePaiement;

public final class CartePaiementConverter {

	private CartePaiementConverter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static CartePaiement cpDtoToCp(CartePaiementDTO cartePaiementDTO) throws Exception {
		
		CartePaiement cartePaiement = new CartePaiement();
		cartePaiement.setNomProprietaire(cartePaiementDTO.getNomProprietaire());
		cartePaiement.setDateFinValidite(cartePaiementDTO.getDateFinValidite());
		cartePaiement.setNumero(ChiffrageUtilisateurEtCp.chiffrageNumCP(cartePaiementDTO));
		cartePaiement.setCryptogramme(ChiffrageUtilisateurEtCp.chiffrageCryptoCP(cartePaiementDTO));
		
		return cartePaiement;
	}

	public static CartePaiementDTO cpToCpDto(CartePaiement cartePaiement) throws Exception {
		
		CartePaiementDTO cartePaiementDTO = new CartePaiementDTO();
		cartePaiementDTO.setNomProprietaire(cartePaiement.getNomProprietaire());
		cartePaiementDTO.setDateFinValidite(cartePaiement.getDateFinValidite());
		cartePaiementDTO.setNumero(ChiffrageUtilisateurEtCp.dechiffrageNumCP(cartePaiement));
		cartePaiementDTO.setCryptogramme(ChiffrageUtilisateurEtCp.dechiffrageCryptoCP(cartePaiement));
		
		return cartePaiementDTO;
	}

	public static CartePaiement updatecpFromCpDto(CartePaiementDTO cartePaiementDTO, CartePaiement cartePaiement) throws Exception {
		
		cartePaiement.setNomProprietaire(cartePaiementDTO.getNomProprietaire());
		cartePaiement.setDateFinValidite(cartePaiementDTO.getDateFinValidite());
		cartePaiement.setNumero(ChiffrageUtilisateurEtCp.chiffrageNumCP(cartePaiementDTO));
		cartePaiement.setCryptogramme(ChiffrageUtilisateurEtCp.chiffrageCryptoCP(cartePaiementDTO));
		
		return cartePaiement;
	}
	
}
