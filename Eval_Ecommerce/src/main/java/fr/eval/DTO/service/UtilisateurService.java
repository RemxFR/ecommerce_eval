package fr.eval.DTO.service;

import java.security.Key;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import fr.eval.DAO.EntityDAO.ParamsDAO;
import fr.eval.DAO.EntityDAO.UtilisateurDAO;
import fr.eval.DTO.entityDTO.UtilisateurDTO;
import fr.eval.entity.Profil;
import fr.eval.entity.Utilisateur;
import fr.eval.security.algo.ChiffrageAES;
import fr.eval.security.keys.GenerateKey;

public class UtilisateurService {

	UtilisateurDAO dao = new UtilisateurDAO();
	
	public UtilisateurService() {
		super();
	}

	public void addUtilisateur(UtilisateurDTO utilisateurDTO) throws Exception {
		System.out.println("----- Entrée dans addUtilisateur service -----");
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(utilisateurDTO.getNom());
		utilisateur.setPrenom(utilisateurDTO.getPrenom());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
		Date dateNaissance = dateFormat.parse(utilisateurDTO.getDateNaissance());
		
		utilisateur.setDateNaissance(dateNaissance);
		utilisateur.setProfil(Profil.CLIENT.name());
		utilisateur.setActif(true);
		utilisateur.setEmail(utilisateurDTO.getEmail());
		utilisateur.setPassword(ChiffrageUtilisateurEtCp.chiffrageMDP(utilisateurDTO.getPassword()));
		utilisateur.setTelephone(utilisateurDTO.getTelephone());
		this.dao.add(utilisateur);
	}
	
	public UtilisateurDTO getByMail(String mail) throws Exception {
		
		Utilisateur utilisateur = this.dao.getByMail(mail);
		UtilisateurDTO dto = new UtilisateurDTO();
		
		dto.setNom(utilisateur.getNom());
		dto.setPrenom(utilisateur.getPrenom());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
		String dateNaissance = dateFormat.format(utilisateur.getDateNaissance());
		
		dto.setDateNaissance(dateNaissance);
		dto.setProfil(Profil.CLIENT.name());
		dto.setEmail(utilisateur.getEmail());
		dto.setPassword(ChiffrageUtilisateurEtCp.dechiffrageMDP(utilisateur.getPassword()));
		dto.setTelephone(utilisateur.getTelephone());
		return dto;
	}

	public UtilisateurDTO authenticateUtilisateur(UtilisateurDTO dto) throws Exception {
		
		UtilisateurDTO dto2 = this.getByMail(dto.getEmail());
		if (dto2 == null) {
			System.out.println("Pas d'utilisateur trouvé avec cette adresse mail");
			return null;
		} else {
			if (dto2.getPassword().equals(dto.getPassword())) {
				
			}
		}
		
		return dto2;
	}
	
}
