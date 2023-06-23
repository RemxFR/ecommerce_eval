package fr.eval.DTO.controller;

import javax.annotation.security.PermitAll;
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

import fr.eval.DTO.entityDTO.AdressDTO;
import fr.eval.DTO.service.AdresseService;
import fr.eval.entity.Adress;

@Path("adress")
@Produces(value = MediaType.TEXT_PLAIN)
public class AdressController {
	private static final String CHARSET = ";charset=UTF-8";
	private AdresseService adresseService = new AdresseService();

	@GET
	@PermitAll
	@Path(value = "infos")
	public String getInfos() {
		return "Info adresse est ok !";
	}

	@GET
	@RolesAllowed({ "ADMIN", "MAGASINIER" })
	@Path(value = "get-{id}")
	public Response getById(@PathParam("id") long id) {

		Adress adress = this.adresseService.getAdresse(id);

		return Response.status(Status.OK.getStatusCode()).entity(adress).build();
	}

	@POST
	@RolesAllowed({ "ADMIN", "MAGASINIER", "CLIENT" })
	@Path("add-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response addAdresse(AdressDTO adressDto, @PathParam("id") long id) {

		this.adresseService.addAdresse(adressDto, id);

		return Response.status(Status.CREATED.getStatusCode()).entity(adressDto).build();
	}

	@PUT
	@RolesAllowed({ "ADMIN", "MAGASINIER" })
	@Path("update-{id}")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response updateAdress(AdressDTO t, @PathParam("id") long id) {

		this.adresseService.updateAdresse(t, id);
		return Response.status(Status.OK.getStatusCode()).entity(t).build();
	}

	@DELETE
	@RolesAllowed({ "ADMIN", "MAGASINIER" })
	@Path("delete-{id}")
	public Response removeAdressById(long id) {
		this.adresseService.deleteAdresse(id);
		return Response.ok().build();
	}

}
