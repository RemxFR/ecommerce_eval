package fr.eval.DTO.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import fr.eval.DAO.EntityDAO.UtilisateurDAO;
import fr.eval.DTO.entityDTO.UtilisateurDTO;
import fr.eval.entity.Utilisateur;

public class AuthenticationService {

	private UtilisateurService utilisateurService = new UtilisateurService();
	private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

	public AuthenticationService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur authenticateUtilisateur(UtilisateurDTO utilisateurDTO) throws Exception {

		System.out.println("------Authenticate Client -----");
		String mdp = null;
		Utilisateur utilisateur = utilisateurDAO.getByMail(utilisateurDTO.getEmail());

		if (utilisateur == null) {
			System.out.println("Email incorrect");
			return null;
		} else {
			mdp = ChiffrageUtilisateurEtCp.dechiffrageMDP(utilisateur.getPassword());

			if (!utilisateurDTO.getPassword().equals(mdp)) {
				System.out.println("mot de passe incorrect");
				utilisateur = null;
			}

		}
		return utilisateur;
	}

}
