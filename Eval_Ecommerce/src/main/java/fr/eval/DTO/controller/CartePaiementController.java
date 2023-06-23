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

import fr.eval.DTO.entityDTO.CartePaiementDTO;
import fr.eval.DTO.service.CartePaiementService;

@Path(value = "carte-paiement")
@Produces(value = MediaType.TEXT_PLAIN)
public class CartePaiementController {
	
	private static final String CHARSET = ";charset=UTF-8";
	private CartePaiementService cpService = new CartePaiementService();
	
	@POST
	@RolesAllowed("CLIENT")
	@Path(value = "add-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response addCartePaiement(CartePaiementDTO cartePaiementDTO, @PathParam("id") long id) {
		
		this.cpService.addCp(cartePaiementDTO, id);
		
		return Response.status(Status.CREATED.getStatusCode()).entity(cartePaiementDTO).build();
	}
	
	@GET
	@RolesAllowed("CLIENT")
	@Path(value = "getById-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response getCartePaiement(@PathParam("id") long id) {
		CartePaiementDTO cartePaiementDTO = this.cpService.getById(id);
		return Response.status(Status.OK.getStatusCode()).entity(cartePaiementDTO).build();
	}

	@PUT
	@RolesAllowed("CLIENT")
	@Path(value = "update-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response updateCartePaiement(CartePaiementDTO cartePaiementDTO, @PathParam("id") long id) {
		this.cpService.updateCp(cartePaiementDTO, id);
		return Response.status(Status.OK.getStatusCode()).entity(cartePaiementDTO).build();
	}
	
	@DELETE
	@RolesAllowed("CLIENT")
	@Path(value = "delete-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response deleteCartePaiement(@PathParam("id") long id) {
		this.cpService.deleteCp(id);
		return Response.status(Status.OK.getStatusCode()).build();
	}
	
}
