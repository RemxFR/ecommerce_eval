package fr.eval.DTO.service;

import java.util.List;
import java.util.Map;

import fr.eval.DAO.EntityDAO.ArticleDAO;
import fr.eval.DAO.EntityDAO.CategorieDAO;
import fr.eval.DTO.entityDTO.ArticleDTO;
import fr.eval.DTO.service.conversions.ArticleConverter;
import fr.eval.entity.Article;
import fr.eval.entity.Categorie;
import fr.eval.entity.Commentaire;

public class ArticleService {

	private ArticleDAO articleDAO = new ArticleDAO();
	private CategorieDAO categorieDAO = new CategorieDAO();

	public ArticleService() {
		super();
	}

	public Map<Article, List<Commentaire>> getCommentairesMapParArticle() throws Exception {

		Map<Article, List<Commentaire>> map = articleDAO.getCommentairesMapParArticle();

		return map;
	}

	public List<Commentaire> getCommentairesListeParArticle(long id) throws Exception {
		List<Commentaire> commentaires = articleDAO.getCommentairesParArticleListe(id);
		return null;
	}

	public void addArticle(Article article, long id) {

		Categorie categorie = null;
		
		try {

			if(id > 0 && (Long) id != null) {
				categorie = this.categorieDAO.getById(id);
				if(categorie != null) {
					article.setCategorie(categorie);
				} else {
					System.out.println("Categorie inexistante...");
				}
			} else {
				System.out.println("L'id doit être un chiffre > 0...");
			}
			
			
			if (article != null) {
				this.articleDAO.add(article);
			} else {
				System.out.println("L'article a enregistré ne peut pas être nul...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateArticle(Article article, long id) {

		try {

			Article articleToUpdate = this.getArticleById(id);

			if (articleToUpdate != null) {

				articleToUpdate = ArticleConverter.updateArticle(articleToUpdate, article);
				this.articleDAO.update(articleToUpdate);

			} else {
				System.out.println("Article inexistant...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Article getArticleById(long id) throws Exception {

		Article article = this.articleDAO.getById(id);

		return article;
	}

	public void removeArticleById(long id) throws Exception {

		this.articleDAO.deleteById(id);

	}

}
