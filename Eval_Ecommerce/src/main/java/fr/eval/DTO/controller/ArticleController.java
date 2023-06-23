package fr.eval.DTO.controller;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.eval.DTO.entityDTO.ArticleDTO;
import fr.eval.DTO.service.ArticleService;
import fr.eval.entity.Article;

@Path("article")
@Produces(value = MediaType.TEXT_PLAIN)
public class ArticleController {

	private static final String CHARSET = ";charset=UTF-8";
	private ArticleService articleService = new ArticleService();
	
	@POST
	@RolesAllowed({"MAGASINIER", "ADMIN"})
	@Path("add-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response addArticle(Article article, @PathParam("id") long id) throws Exception {
		
		articleService.addArticle(article, id);
		
		return Response.status(Status.CREATED.getStatusCode(), "Création de l'article réussie !")
				.entity(article)
				.build();
		
	}
	
	@PUT
	@RolesAllowed({"MAGASINIER", "ADMIN"})
	@Path("update-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response updateArticle(Article article, @PathParam("id") long id) {
		
		articleService.updateArticle(article, id);
		
		return Response.status(Status.OK.getStatusCode())
				.entity("Update de l'article réussie !")
				.build();
		
	}
	
	@GET
	@RolesAllowed({"MAGASINIER", "ADMIN"})
	@Path("get-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
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
