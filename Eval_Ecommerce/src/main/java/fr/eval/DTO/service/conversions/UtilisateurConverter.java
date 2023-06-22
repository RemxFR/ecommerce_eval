package fr.eval.DTO.service.conversions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import fr.eval.DTO.entityDTO.UtilisateurDTO;
import fr.eval.DTO.service.ChiffrageUtilisateurEtCp;
import fr.eval.entity.Profil;
import fr.eval.entity.Utilisateur;

public final class UtilisateurConverter {

	private UtilisateurConverter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static UtilisateurDTO convertUtilisateurEnDto(Utilisateur utilisateur) throws Exception {
		UtilisateurDTO dto = new UtilisateurDTO();
		dto.setId(utilisateur.getId());
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

	public static Utilisateur updateUtilisateurFromDto(Utilisateur utilisateur, UtilisateurDTO dto) throws Exception {

		utilisateur.setNom(dto.getNom());
		utilisateur.setPrenom(dto.getPrenom());

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
		Date dateNaissance = dateFormat.parse(dto.getDateNaissance());

		utilisateur.setDateNaissance(dateNaissance);
		utilisateur.setEmail(dto.getEmail());
		utilisateur.setTelephone(dto.getTelephone());

		return utilisateur;
	}

}
