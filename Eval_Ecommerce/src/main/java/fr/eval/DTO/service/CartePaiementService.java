package fr.eval.DTO.service;

import fr.eval.DAO.EntityDAO.CartePaiementDAO;
import fr.eval.DAO.EntityDAO.UtilisateurDAO;
import fr.eval.DTO.entityDTO.CartePaiementDTO;
import fr.eval.DTO.service.conversions.CartePaiementConverter;
import fr.eval.entity.CartePaiement;
import fr.eval.entity.Utilisateur;

public class CartePaiementService {

	private CartePaiementDAO cartePaiementDAO = new CartePaiementDAO();
//	private UtilisateurService utilisateurService = new UtilisateurService();
	private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

	public void addCp(CartePaiementDTO cartePaiementDTO, long id) {

		CartePaiement cartePaiement = null;
		Utilisateur utilisateur = null;
		try {
			if (cartePaiementDTO != null) {
				cartePaiement = CartePaiementConverter.cpDtoToCp(cartePaiementDTO);
			} else {
				System.out.println("La carte de paiement à enregistrer ne doit pas être nulle...");
			}

			if (id > 0 & (Long) id != null) {
				utilisateur = this.utilisateurDAO.getById(id);
				if (utilisateur != null) {
					cartePaiement.setUtilisateur(utilisateur);
					this.cartePaiementDAO.add(cartePaiement);
				} else {
					System.out.println("Utilisateur inexistant...");
				}
			} else {
				System.out.println("L'id doit être un chiffre stictement supérieur à 0...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public CartePaiementDTO getById(long id) {

		CartePaiementDTO cartePaiementDTO = null;
		CartePaiement cartePaiement = null;

		try {
			if (id > 0 && (Long) id != null) {
				cartePaiement = this.cartePaiementDAO.getById(id);

				if (cartePaiement != null) {
					cartePaiementDTO = CartePaiementConverter.cpToCpDto(cartePaiement);
				} else {
					System.out.println("Carte de paiement inexistante...");
				}

			} else {
				System.out.println("L'id doit être un chiffre stictement supérieur à 0...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartePaiementDTO;
	}

	public void updateCp(CartePaiementDTO cartePaiementDTO, long id) {

		CartePaiement cartePaiement = null;

		try {
			if (id > 0 && (Long) id != null) {
				cartePaiement = this.cartePaiementDAO.getById(id);

				if (cartePaiement != null) {
					cartePaiement = CartePaiementConverter.updatecpFromCpDto(cartePaiementDTO, cartePaiement);
					this.cartePaiementDAO.update(cartePaiement);
				} else {
					System.out.println("Carte de paiement inexistante...");
				}

			} else {
				System.out.println("L'id doit être un chiffre stictement supérieur à 0...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCp(long id) {
	
		CartePaiement cartePaiement = null;
		
		try {
			if (id > 0 && (Long) id != null) {
				cartePaiement = this.cartePaiementDAO.getById(id);

				if (cartePaiement != null) {
					this.cartePaiementDAO.deleteById(id);
				} else {
					System.out.println("Carte de paiement inexistante...");
				}

			} else {
				System.out.println("L'id doit être un chiffre stictement supérieur à 0...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
