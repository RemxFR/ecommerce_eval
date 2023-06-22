package fr.eval.DTO.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import fr.eval.DAO.EntityDAO.AdressDAO;
import fr.eval.DAO.EntityDAO.UtilisateurDAO;
import fr.eval.DTO.entityDTO.ArticleDTO;
import fr.eval.DTO.entityDTO.ArticlePanierDTO;
import fr.eval.DTO.entityDTO.UtilisateurDTO;
import fr.eval.DTO.service.conversions.UtilisateurConverter;
import fr.eval.entity.Adress;
import fr.eval.entity.Article;
import fr.eval.entity.ArticlePanier;
import fr.eval.entity.Profil;
import fr.eval.entity.Utilisateur;

public class UtilisateurService {

	UtilisateurDAO utilisateurDao = new UtilisateurDAO();
	AdressDAO adressDAO = new AdressDAO();

	public UtilisateurService() {
		super();
	}

	public void addUtilisateur(UtilisateurDTO utilisateurDTO, String profil) throws Exception {
		System.out.println("----- Entrée dans addUtilisateur service -----");
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(utilisateurDTO.getNom());
		utilisateur.setPrenom(utilisateurDTO.getPrenom());

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
		Date dateNaissance = dateFormat.parse(utilisateurDTO.getDateNaissance());

		utilisateur.setDateNaissance(dateNaissance);

		switch (profil) {
		case "CLIENT":
			utilisateur.setProfil(Profil.CLIENT.name());
			break;
		case "MAGASINIER":
			utilisateur.setProfil(Profil.MAGASINIER.name());
			break;
		case "ADMIN":
			utilisateur.setProfil(Profil.ADMIN.name());
		}

		utilisateur.setActif(false);
		utilisateur.setEmail(utilisateurDTO.getEmail());
		utilisateur.setPassword(ChiffrageUtilisateurEtCp.chiffrageMDP(utilisateurDTO.getPassword()));
		utilisateur.setTelephone(utilisateurDTO.getTelephone());

		this.utilisateurDao.add(utilisateur);
		
		if (utilisateur.getAdresse() != null) {
			Adress adress = new Adress();
			adress.setNumero(utilisateurDTO.getAdressDTO().getNumero());
			adress.setRue(utilisateurDTO.getAdressDTO().getRue());
			adress.setCodePostal(utilisateurDTO.getAdressDTO().getCodePostal());
			adress.setVille(utilisateurDTO.getAdressDTO().getVille());
			adress.setUtilisateur(utilisateur);
			this.adressDAO.add(adress);
		}

	}

	public UtilisateurDTO getByMail(String mail) throws Exception {

		Utilisateur utilisateur = this.utilisateurDao.getByMail(mail);
		UtilisateurDTO dto = new UtilisateurDTO();

		dto = UtilisateurConverter.convertUtilisateurEnDto(utilisateur);

		return dto;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
//	public Map<UtilisateurDTO, List<ArticleDTO>> getUtilisateurAvecPanierNonVide() throws Exception {
//
//		Map<UtilisateurDTO, List<ArticleDTO>> map = new HashMap<>();
//
//		List<UtilisateurDTO> utilisateursDtos = new ArrayList<>();
//		List<ArticleDTO> articles = new ArrayList<>();
//		List<ArticlePanierDTO> articlesPanierDTO = new ArrayList<>();
//		List<Utilisateur> utilisateurs = utilisateurDao.getAllUtilisateurs();
//
//		// Transforme les utilisateurs en utilisateurDTOs
//		if (utilisateurs != null || !utilisateurs.isEmpty()) {
//			for (Utilisateur utilisateur : utilisateurs) {
//
//				UtilisateurDTO dto = this.convertUtilisateurEnDto(utilisateur);
//
//				utilisateursDtos.add(dto);
//			}
//		} else {
//			System.out.println("Aucun utilisateur trouvé.");
//			return null;
//		}
//
//		// Transforme les articlePaniers en articlePaniersDtos
//		for (Utilisateur utilisateur : utilisateurs) {
//			articlesPanierDTO = this.convertArticlePanierEnDto(utilisateur.getPanier());
//		}
//
//		// Transforme chaque article du panierDto en articleDto
//		for (int i = 0; i < utilisateursDtos.size(); i++) {
//			if (articlesPanierDTO.get(i).getUtilisateur().getId() == utilisateursDtos.get(i).getId()) {
//				List<ArticleDTO> articleDTOs = new ArrayList<>();
//
//				for (ArticlePanierDTO articlePanierDTO : utilisateursDtos.get(i).
//				}
//				map.put(utilisateursDtos.get(i), articlesPanierDTO.get(i).getArticleDTO())
//			}
//		}
//
//		// Ajoute pour chaque utilisateurDto sa liste d'articleDtos associés
//
//		return map;
//	}
//
//	private List<ArticlePanierDTO> convertArticlePanierEnDto(Set<ArticlePanier> articlesSet) throws Exception {
//
//		List<ArticlePanierDTO> articlePanierDTOs = new ArrayList<>();
//
//		for (ArticlePanier articlePanier : articlesSet) {
//			ArticlePanierDTO articlePanierDTO = new ArticlePanierDTO();
//			articlePanierDTO.setId(articlePanier.getId());
//			articlePanierDTO.setArticleDTO(this.convertArticleEnDTO(articlePanier.getArticle()));
//			articlePanierDTO.setQuantite(articlePanier.getQuantite());
//			articlePanierDTO.setUtilisateur(UtilisateurConverter.convertUtilisateurEnDto(articlePanier.getUtilisateur()));
//
//			articlePanierDTOs.add(articlePanierDTO);
//		}
//		return articlePanierDTOs;
//	}

}
