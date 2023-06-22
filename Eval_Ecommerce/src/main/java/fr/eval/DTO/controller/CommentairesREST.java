package fr.eval.DTO.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.eval.DTO.service.ArticleService;
import fr.eval.DTO.service.CommentaireService;
import fr.eval.entity.Article;
import fr.eval.entity.Commentaire;

@Path("commentaires")
@Produces(value = MediaType.TEXT_PLAIN)
public class CommentairesREST {

	private CommentaireService cs = new CommentaireService();
	private ArticleService as = new ArticleService();
	
	
	
	
	@GET
	@PermitAll
	@Path("get-commentaires-{id}")
	public Response getCommentairesList(@PathParam("id") long id) throws Exception {
		
		List<Commentaire> commentaires = as.getCommentairesListeParArticle(id);
		return Response.status(Status.OK.getStatusCode())
				.entity(commentaires)
				.build();
	}
	
	@GET
	@RolesAllowed("ADMIN")
	@Path("get-commentaires-par-article")
	public Response getCommentairesByArticle() throws Exception {
		
		Map<Article, List<Commentaire>> map = as.getCommentairesMapParArticle();
		return Response.status(Status.OK.getStatusCode())
				.entity(map)
				.build();
	}
	
	
	@POST
	@RolesAllowed({"MAGASINIER", "ADMIN", "CLIENT"})
	@Path("add")
	public Response addCommentaire(Commentaire commentaire) {
		
		this.cs.addCommentaire(commentaire);
		
		return Response.status(Status.CREATED.getStatusCode(), "Création de l'article réussie !")
				.entity(commentaire)
				.build();
		
	}
	
	@PATCH
	@RolesAllowed({"MAGASINIER", "ADMIN", "CLIENT"})
	@Path("update-{id}")
	public Response updateCommentaire(Commentaire commentaire, @PathParam("id") long id) {
		
		this.cs.updateCommentaire(commentaire, id);
		
		return Response.status(Status.OK.getStatusCode())
				.entity("Update de l'article réussie !")
				.build();
		
	}
	
	@GET
	@RolesAllowed({"MAGASINIER", "ADMIN", "CLIENT"})
	@Path("get-{id}")
	public Response getCommentaireById(@PathParam("id") long id) {
		
		Commentaire commentaire = this.cs.getCommentaireById(id);
		
		return Response.status(Status.CREATED.getStatusCode(), "Commentaire trouvé dans la base de données !")
				.entity(commentaire)
				.build();
		
	}
	
	@DELETE
	@RolesAllowed({"MAGASINIER", "ADMIN", "CLIENT"})
	@Path("remove-{id}")
	public Response removeACommentaireById(@PathParam("id") long id) {
		
		this.cs.removeCommentaireById(id);
		
		return Response.status(Status.CREATED.getStatusCode())
				.entity("Suppression du commentaire réussie !")
				.build();
		
	}
	
}
