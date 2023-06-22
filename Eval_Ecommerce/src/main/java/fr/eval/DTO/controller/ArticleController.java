package fr.eval.DTO.controller;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.eval.DTO.service.ArticleService;
import fr.eval.entity.Article;

@Path("article")
public class ArticleController {

	private ArticleService articleService = new ArticleService();
	
	@POST
	@RolesAllowed({"MAGASINIER", "ADMIN"})
	@Path("add")
	public Response addArticle(Article article) throws Exception {
		
		articleService.addArticle(article);
		
		return Response.status(Status.CREATED.getStatusCode(), "Création de l'article réussie !")
				.entity(article)
				.build();
		
	}
	
	@PATCH
	@RolesAllowed({"MAGASINIER", "ADMIN"})
	@Path("add")
	public Response updateArticle(Article article) throws Exception {
		
		articleService.updateArticle(article);
		
		return Response.status(Status.CREATED.getStatusCode())
				.entity("Update de l'article réussie !")
				.build();
		
	}
	
	@GET
	@RolesAllowed({"MAGASINIER", "ADMIN"})
	@Path("get-{id}")
	public Response getArticleById(@PathParam("id") long id) throws Exception {
		
		Article article = articleService.getArticleById(id);
		
		return Response.status(Status.CREATED.getStatusCode(), "Article trouvé dans la base de données !")
				.entity(article)
				.build();
		
	}
	
	@DELETE
	@RolesAllowed({"MAGASINIER", "ADMIN"})
	@Path("remove-{id}")
	public Response removeArticleById(@PathParam("id") long id) throws Exception {
		
		articleService.removeArticleById(id);
		
		return Response.status(Status.CREATED.getStatusCode())
				.entity("Suppression de l'article réussie !")
				.build();
		
	}
}
