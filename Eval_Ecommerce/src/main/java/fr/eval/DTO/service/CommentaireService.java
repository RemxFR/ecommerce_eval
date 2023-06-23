package fr.eval.DTO.service;

import java.util.List;

import fr.eval.DAO.EntityDAO.ArticleDAO;
import fr.eval.DAO.EntityDAO.CommentaireDAO;
import fr.eval.DTO.service.conversions.CommentaireConverter;
import fr.eval.entity.Article;
import fr.eval.entity.Commentaire;

public class CommentaireService {

	private CommentaireDAO commentaireDAO = new CommentaireDAO();
	private ArticleDAO articleDAO = new ArticleDAO();

	public CommentaireService() {
	}

	public List<Commentaire> getCommentairesListe(long id) throws Exception {

		List<Commentaire> commentaires = articleDAO.getCommentairesParArticleListe(id);

		return commentaires;
	}

	public void addCommentaire(Commentaire commentaire, long id) {
		Article article = null;
		try {
			if (commentaire != null) {
				
				if (id > 0 && (Long) id != null) {
					article = this.articleDAO.getById(id);
					if (article != null) {
						commentaire.setArticle(article);
					} else {
						System.out.println("Article inexistant...");
					}
				} else {
					System.out.println("L'id doit être un chiffre strictement supérieur à 0...");
				}

				this.commentaireDAO.add(commentaire);
				
			} else {
				System.out.println("Un commentaire ne peut pas être nul...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateCommentaire(Commentaire commentaire, long id) {

		Commentaire commentaireToUpdate = null;

		try {

			commentaireToUpdate = this.commentaireDAO.getById(id);
			if (commentaireToUpdate != null) {
				commentaireToUpdate = CommentaireConverter.updateCommentaire(commentaireToUpdate, commentaire);
				this.commentaireDAO.update(commentaireToUpdate);
			} else {
				System.out.println("Commentaire inexistant...s");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Commentaire getCommentaireById(long id) {

		Commentaire commentaire = null;

		try {
			if (id > 0 && (Long) id != null) {

				commentaire = this.commentaireDAO.getById(id);

				if (commentaire == null) {
					System.out.println("Commentaire inexistant...");
				}

			} else {
				System.out.println("L'id doit être un chiffre strictement supérieur à 0...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return commentaire;
	}

	public void removeCommentaireById(long id) {

		Commentaire commentaire = null;

		try {

			commentaire = this.getCommentaireById(id);
			if (commentaire != null) {
				this.commentaireDAO.deleteById(id);
			} else {
				System.out.println("Suppression du commentaire impossible car id inexistant...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
