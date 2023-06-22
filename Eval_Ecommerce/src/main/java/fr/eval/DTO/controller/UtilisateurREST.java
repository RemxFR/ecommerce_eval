package fr.eval.DTO.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.eval.DTO.entityDTO.ArticleDTO;
import fr.eval.DTO.entityDTO.UtilisateurDTO;
import fr.eval.DTO.service.UtilisateurService;
import fr.eval.entity.Utilisateur;

@Path("utilisateur")
@Produces(value = MediaType.TEXT_PLAIN)
public class UtilisateurREST implements IControllerRest<UtilisateurDTO>{
	
	private static final String CHARSET = ";charset=UTF-8"; 
	
	private UtilisateurService utilisateurService = new UtilisateurService();

	@PermitAll
	@Path("infos")
	@GET
	@Override
	public String getInfos() throws Exception {
		String getInfos = "Test utilisateur get infos";
		return getInfos;
	}

	@RolesAllowed("CLIENT")
	@Override
	public UtilisateurDTO getById(long id) throws Exception {
		return null;
	}
	
	@RolesAllowed("CLIENT")
	@GET
	@Path("get-user-{mail}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response getByMail(@PathParam(value = "mail") String mail) throws Exception {
		
		UtilisateurDTO ut = utilisateurService.getByMail(mail);
		return Response.status(Status.OK.getStatusCode()).entity(ut).build();
		
	}
	
	@RolesAllowed("CLIENT")
	@Override
	public Response updateT(UtilisateurDTO t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@RolesAllowed("CLIENT")
	@Override
	public Response removeTById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GET
	@RolesAllowed("ADMIN")
	@Path("get-client-avec-panier-non-vide")
	public Response getUtilisateurAvecPanierNonVide() throws Exception {
		
		Map<UtilisateurDTO, List<ArticleDTO>> map = utilisateurService.getUtilisateurAvecPanierNonVide();
		
		
		return Response.status(Status.OK.getStatusCode())
				.entity(map)
				.build();
		
	}

	@Override
	public Response addT(UtilisateurDTO t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
