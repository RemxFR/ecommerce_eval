package fr.eval.DTO.service.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig {

	public CustomApplication() {

		packages("fr.eval.DTO.controller");
		
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
				Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 1000));
		
		register(AuthentificationFilter.class);
		register(CORSFilter.class);
		
	}
	
}
