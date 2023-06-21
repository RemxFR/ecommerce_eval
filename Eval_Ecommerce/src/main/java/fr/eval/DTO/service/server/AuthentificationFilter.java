package fr.eval.DTO.service.server;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthentificationFilter implements javax.ws.rs.container.ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHORIZATION_SCHEME = "Bearer";

	private Response getAccessDeniedResponse() {
		return Response.status(Response.Status.UNAUTHORIZED)
				.entity("Vous n'avez pas le droit d'accéder à cette ressource").build();
	}

	private Response getAccessForbissenResponse() {
		return Response.status(Response.Status.FORBIDDEN).entity("Accès bloqué à tous les utilisateurs").build();
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		Method method = resourceInfo.getResourceMethod();
		int nbrIteration = 0;

		if (method.isAnnotationPresent(PermitAll.class)) {
			nbrIteration++;
		}
		if (method.isAnnotationPresent(DenyAll.class)) {
			nbrIteration++;
		}
		if (method.isAnnotationPresent(RolesAllowed.class)) {
			nbrIteration++;
		}

		if (nbrIteration > 1) {
			throw new IOException("Une méthode ne peut pas avoir plus d'une annotation !");
			// throw new exception côté server => Une méthode ne doit pas avoir plus d'une
			// annotation
		}
		if (nbrIteration == 0) {
			throw new IOException("Une méthode doit avoir au moins une annotation !");
			// throw new exception côté server => Une méthode doit avoir au moins une
			// annotation
		}

		if (!method.isAnnotationPresent(PermitAll.class)) {
			if (method.isAnnotationPresent(DenyAll.class)) {
				requestContext.abortWith(getAccessDeniedResponse());
				return;
			}

			final MultivaluedMap<String, String> headers = requestContext.getHeaders();
			final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

			if (authorization == null || authorization.isEmpty()) {
				requestContext.abortWith(getAccessDeniedResponse());
				return;
			}

			final String profil = authorization.get(0).replaceFirst(AUTHORIZATION_SCHEME + " ", "");

			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
				Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAllowed.value()));

				if (!isUserAllowed(profil, rolesSet)) {
					requestContext.abortWith(getAccessDeniedResponse());
					return;
				}
			}

		}

	}

	private boolean isUserAllowed(final String profil, final Set<String> rolesSet) {
		boolean isAllowed = false;

		switch (profil) {
		case "ADMIN":
			if (rolesSet.contains(profil)) {
				isAllowed = true;
			}
			break;
		case "MAGASINIER":
			if (rolesSet.contains(profil)) {
				isAllowed = true;
			}
			break;
		case "CLIENT":
			if (rolesSet.contains(profil)) {
				isAllowed = true;
			}
			break;
		default:
			isAllowed = false;
		}

		return isAllowed;
	}

}
