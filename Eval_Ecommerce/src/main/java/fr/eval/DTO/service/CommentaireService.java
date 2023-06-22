package fr.eval.DTO.service;

import java.util.List;

import fr.eval.DAO.EntityDAO.ArticleDAO;
import fr.eval.DAO.EntityDAO.CommentaireDAO;
import fr.eval.entity.Commentaire;

public class CommentaireService {

	private CommentaireDAO commentaireDAO = new CommentaireDAO();
	private ArticleDAO articleDAO = new ArticleDAO();
	
	public CommentaireService(){}

	public List<Commentaire> getCommentairesListe(long id) throws Exception {
		
		List<Commentaire> commentaires = articleDAO.getCommentairesParArticleListe(id);
		
		return commentaires;
	}
	
}
