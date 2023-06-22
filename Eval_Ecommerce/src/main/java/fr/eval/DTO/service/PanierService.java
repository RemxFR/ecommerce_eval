package fr.eval.DTO.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.eval.DAO.EntityDAO.ArticlePanierDAO;
import fr.eval.DAO.EntityDAO.UtilisateurDAO;
import fr.eval.entity.ArticlePanier;
import fr.eval.entity.Utilisateur;

public class PanierService {

	private ArticlePanierDAO articlePanierDAO = new ArticlePanierDAO();
	private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

	public void addArticlePanier(ArticlePanier articlePanier, long id) {

		Utilisateur utilisateur = null;

		try {

			if (articlePanier != null) {

				utilisateur = this.utilisateurDAO.getById(id);

				if (utilisateur != null) {

					articlePanier.setUtilisateur(utilisateur);
					this.articlePanierDAO.add(articlePanier);

				} else {
					System.out.println("Utilisateur inexistant...");
				}
			} else {
				System.out.println("L'objet ArticlePanier ne peut pas être nul...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateArticlePanier(ArticlePanier articlePanierUpdate, long id) {

		ArticlePanier articlePanierToUpdate = null;

		try {

			if (articlePanierUpdate != null) {

				if (id > 0 && (Long) id != null) {

					articlePanierToUpdate = this.articlePanierDAO.getById(id);

					if (articlePanierToUpdate != null) {

						this.articlePanierDAO.update(articlePanierToUpdate);

					} else {
						System.out.println("ArticlePanier iniexistant...");
					}
					System.out.println("L'id doit être un chiffre strictement supérieur à 0...");
				} else {
					System.out.println("L'objet Article Panier reçu pour l'update ne peut pas être nul...");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteArticlePanier(long id) {

		ArticlePanier articlePanierToDelete = null;

		try {

			if (id > 0 && (Long) id != null) {
				articlePanierToDelete = this.articlePanierDAO.getById(id);

				if (articlePanierToDelete != null) {
					this.articlePanierDAO.deleteById(id);
				} else {
					System.out.println("Article inexistant...");
				}
			} else {
				System.out.println("L'id doit être un chiffre strictement supérieur à 0...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<ArticlePanier> getPanier(long id) {

		List<ArticlePanier> panierList = null;
		Set<ArticlePanier> panier = null;

		try {

			if (id > 0 && (Long) id != null) {

				panierList = this.articlePanierDAO.getPanierByIdClient(id);

				if (panierList == null) {
					System.out.println("Client inexistant...");
				} else {

					panier = new HashSet<>(panierList);

				}

			} else {
				System.out.println("L'id doit être un chiffre strictement supérieur à 0...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return panier;
	}

}
