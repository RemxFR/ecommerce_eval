package fr.eval.DTO.service;

import java.util.List;

import fr.eval.DAO.EntityDAO.CommentaireDAO;
import fr.eval.entity.Commentaire;

public class CommentaireService {

	private CommentaireDAO commentaireDAO = new CommentaireDAO();
	
	public CommentaireService(){}

	public List<Commentaire> getCommentairesListe() throws Exception {
		
		List<Commentaire> commentaires = commentaireDAO.getCommentaireList();
		
		return commentaires;
	}
	
}
