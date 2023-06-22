package fr.eval.DTO.service.conversions;

import fr.eval.entity.Commentaire;

public final class CommentaireConverter {

	private CommentaireConverter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Commentaire updateCommentaire(Commentaire commentaireToUpdate, Commentaire commentaireUpdate) {
		
		commentaireToUpdate.setTexte(commentaireUpdate.getTexte());
		commentaireToUpdate.setNote(commentaireUpdate.getNote());
		
		return commentaireToUpdate;
	}
}
