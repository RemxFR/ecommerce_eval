package fr.eval.DTO.controller;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
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

import fr.eval.DTO.service.CategorieService;
import fr.eval.entity.Categorie;

@Path("categorie")
@Produces(MediaType.TEXT_PLAIN)
public class CategorieController {
	
	private static final String CHARSET = ";charset=UTF-8";
	private CategorieService categorieService = new CategorieService();

	@POST
	@RolesAllowed({ "MAGASINIER", "ADMIN" })
	@Path("add")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response addCategorie(Categorie categorie) throws Exception {

		categorieService.addCategorie(categorie);

		return Response.status(Status.CREATED.getStatusCode(), "Création de l'article réussie !").entity(categorie)
				.build();

	}

	@PUT
	@RolesAllowed({ "MAGASINIER", "ADMIN" })
	@Path("update-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response updateCategorie(Categorie categorie, @PathParam("id") long id) throws Exception {

		categorieService.updateCategorie(categorie, id);

		return Response.status(Status.CREATED.getStatusCode()).entity("Update de l'article réussie !").build();

	}

	@GET
	@RolesAllowed({ "MAGASINIER", "ADMIN" })
	@Path("get-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response getCategorieById(@PathParam("id") long id) throws Exception {

		Categorie article = categorieService.getCategorieById(id);

		return Response.status(Status.CREATED.getStatusCode(), "Article trouvé dans la base de données !")
				.entity(article).build();

	}

	@DELETE
	@RolesAllowed({ "MAGASINIER", "ADMIN" })
	@Path("remove-{id}")
	public Response removeCategorieById(@PathParam("id") long id) throws Exception {

		categorieService.removeCategorieById(id);

		return Response.status(Status.CREATED.getStatusCode()).entity("Suppression de l'article réussie !").build();

	}

}
