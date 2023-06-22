package fr.eval.DTO.controller;

import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.eval.DTO.service.PanierService;
import fr.eval.entity.ArticlePanier;

@Path(value = "panier")
@Produces(MediaType.TEXT_PLAIN)
public class PanierController {

	private PanierService panierService = new PanierService();

	@POST
	@RolesAllowed("CLIENT")
	@Path("add-{id}")
	public Response addArticlePanier(ArticlePanier articlePanier, @PathParam("id") long id) {

		this.panierService.addArticlePanier(articlePanier, id);
		return Response.status(Status.OK.getStatusCode()).build();
	}

	@PUT
	@RolesAllowed("CLIENT")
	@Path("update-{id}")
	public Response updateArticlePanier(ArticlePanier articlePanier, @PathParam("id") long id) {
		this.panierService.updateArticlePanier(articlePanier, id);
		return Response.status(Status.OK.getStatusCode()).build();
	}

	@DELETE
	@RolesAllowed("CLIENT")
	@Path("delete-{id}")
	public Response deleteArticlePanier(@PathParam("id") long id) {
		this.panierService.deleteArticlePanier(id);
		return Response.status(Status.OK.getStatusCode()).build();
	}

	@GET
	@RolesAllowed("CLIENT")
	@Path("get-panier-{id}")
	public Response getPanier(@PathParam("id") long id) {
		Set<ArticlePanier> paniers = this.panierService.getPanier(id);
		return Response.status(Status.OK).entity(paniers).build();
	}
}
