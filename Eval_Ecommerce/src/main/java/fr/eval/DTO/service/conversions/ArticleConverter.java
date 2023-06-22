package fr.eval.DTO.service.conversions;

import fr.eval.DTO.entityDTO.ArticleDTO;
import fr.eval.entity.Article;

public final class ArticleConverter {

	private ArticleConverter() {}
	

	public static ArticleDTO convertArticleEnDTO(Article article) {

		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setId(article.getId());
		articleDTO.setNom(article.getNom());
		articleDTO.setPhotos(article.getPhotos());
		return articleDTO;
	}
	
	public static Article updateArticle(Article articleToUpdate, Article articleUpdate) {
	
		articleToUpdate.setNom(articleUpdate.getNom());
		articleToUpdate.setPrix(articleUpdate.getPrix());
		articleToUpdate.setDescription(articleUpdate.getDescription());
		articleToUpdate.setCategorie(articleUpdate.getCategorie());
		articleToUpdate.setPhotos(articleUpdate.getPhotos());
		articleToUpdate.setVideos(articleUpdate.getVideos());
		articleToUpdate.setRemise(articleUpdate.getRemise());
		articleToUpdate.setStock(articleUpdate.getStock());
		articleToUpdate.setVendable(articleUpdate.isVendable());
		
		return articleToUpdate;
	}
	
}
