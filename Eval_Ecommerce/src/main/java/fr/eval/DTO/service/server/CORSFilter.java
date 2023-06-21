package fr.eval.DTO.service.server;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest servletRequest = (HttpServletRequest) request;

		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, X-Auth-Token");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Credentials", "true");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Request-Headers", "Origin, X-Custom-Header, X-Requested-With, Authorization, Content-Type, Accept");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Expose-Headers", "Content-Length, X-Kuma-Revision");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
		
		chain.doFilter(servletRequest, servletResponse);
	}

}
