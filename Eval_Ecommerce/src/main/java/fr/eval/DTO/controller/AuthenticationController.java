package fr.eval.DTO.controller;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.eval.DTO.entityDTO.UtilisateurDTO;
import fr.eval.DTO.service.AuthenticationService;
import fr.eval.DTO.service.UtilisateurService;
import fr.eval.entity.Profil;
import fr.eval.entity.Utilisateur;

@Path(value = "connexion")
@Produces(value = MediaType.TEXT_PLAIN)
public class AuthenticationController {

	private static final String CHARSET = ";charset=UTF-8";

	private AuthenticationService authService = new AuthenticationService();
	private UtilisateurService utilisateurService = new UtilisateurService();

	@POST
	@PermitAll
	@Path("authenticate")
	@Produces(value = MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(value = MediaType.APPLICATION_JSON + CHARSET)
	public Response Authenticate(UtilisateurDTO utilisateurDTO) throws Exception {

		Utilisateur utilisateur = authService.authenticateUtilisateur(utilisateurDTO);
		return Response.status(Status.OK.getStatusCode()).entity(utilisateur).build();
	}

	@PermitAll
	@POST
	@Path("add-user")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response addClient(UtilisateurDTO utilisateurDTO) throws Exception {
		Utilisateur utilisateur = this.utilisateurService.addUtilisateur(utilisateurDTO, Profil.CLIENT.name());
		return Response.status(Status.CREATED.getStatusCode(), "Enregistrement de l'utilisateur réussi")
				.entity(utilisateur).build();
	}

	@RolesAllowed("ADMIN")
	@POST
	@Path("add-magasinier")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response addMagasinier(UtilisateurDTO utilisateurDTO) throws Exception {
		utilisateurService.addUtilisateur(utilisateurDTO, Profil.MAGASINIER.name());
		return Response.status(Status.CREATED.getStatusCode(), "Enregistrement de l'utilisateur réussi")
				.entity(utilisateurDTO).build();
	}

	@RolesAllowed("ADMIN")
	@POST
	@Path("add-admin")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response addAdmin(UtilisateurDTO utilisateurDTO) throws Exception {
		utilisateurService.addUtilisateur(utilisateurDTO, Profil.ADMIN.name());
		return Response.status(Status.CREATED.getStatusCode(), "Enregistrement de l'utilisateur réussi")
				.entity(utilisateurDTO).build();
	}

}
