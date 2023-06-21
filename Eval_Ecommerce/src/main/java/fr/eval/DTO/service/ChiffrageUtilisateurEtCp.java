package fr.eval.DTO.service;

import java.security.Key;

import fr.eval.DAO.EntityDAO.ParamsDAO;
import fr.eval.DTO.entityDTO.CartePaiementDTO;
import fr.eval.DTO.entityDTO.UtilisateurDTO;
import fr.eval.entity.CartePaiement;
import fr.eval.entity.Utilisateur;
import fr.eval.security.algo.ChiffrageAES;

public class ChiffrageUtilisateurEtCp {

	private static ParamsDAO paramsDAO;
	private static Key key;

	private ChiffrageUtilisateurEtCp() {
		super();
	}

	public static byte[] chiffrageMDP(String password) throws Exception {

		
		paramsDAO = new ParamsDAO();
		key = paramsDAO.getCleDeChiffrageMdp();

		byte[] mdpChiffre = ChiffrageAES.chiffrage(password, key);

		return mdpChiffre;
	}

	public static String dechiffrageMDP(byte[] mdpADechiffrer) throws Exception {

		UtilisateurDTO utilisateurDTO = null;
		paramsDAO = new ParamsDAO();
		key = paramsDAO.getCleDeChiffrageMdp();

		String mdpDechiffre = ChiffrageAES.dechiffrage(mdpADechiffrer, key);

		return mdpDechiffre;
	}

	public static byte[] chiffrageNumCP(CartePaiementDTO cpDTO) throws Exception {

		CartePaiement cartePaiement = null;
		paramsDAO = new ParamsDAO();
		key = paramsDAO.getCleDeChiffrageMdp();

		byte[] numChiffre = ChiffrageAES.chiffrage(cpDTO.getNumero(), key);

		return numChiffre;
	}

	public static String dechiffrageNumCP(CartePaiement cartePaiement) throws Exception {

		CartePaiementDTO cartePaiementDTO = null;
		paramsDAO = new ParamsDAO();
		key = paramsDAO.getCleDeChiffrageMdp();

		String numDechiffre = ChiffrageAES.dechiffrage(cartePaiement.getNumero(), key);

		return numDechiffre;
	}

	public static byte[] chiffrageCryptoCP(CartePaiementDTO cpDTO) throws Exception {

		CartePaiement cartePaiement = null;
		paramsDAO = new ParamsDAO();
		key = paramsDAO.getCleDeChiffrageMdp();

		byte[] cryptoChiffre = ChiffrageAES.chiffrage(cpDTO.getCryptogramme(), key);

		return cryptoChiffre;
	}

	public static String dechiffrageCryptoCP(CartePaiement cartePaiement) throws Exception {

		CartePaiementDTO cartePaiementDTO = null;
		paramsDAO = new ParamsDAO();
		key = paramsDAO.getCleDeChiffrageMdp();

		String cryptoDechiffre = ChiffrageAES.dechiffrage(cartePaiement.getCryptogramme(), key);

		return cryptoDechiffre;
	}

}
