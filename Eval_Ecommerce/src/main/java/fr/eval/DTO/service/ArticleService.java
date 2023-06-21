package fr.eval.DTO.service;

import java.util.List;
import java.util.Map;

import fr.eval.DAO.EntityDAO.ArticleDAO;
import fr.eval.entity.Article;
import fr.eval.entity.Commentaire;

public class ArticleService {

	private ArticleDAO articleDAO = new ArticleDAO();
	
	
	
	public ArticleService() {
		super();
	}



	public Map<Article, List<Commentaire>> getCommentairesParArticle() throws Exception {
		
		Map<Article, List<Commentaire>> map = articleDAO.getCommentairesParArticle();
		
		return map;
	}
	
}
