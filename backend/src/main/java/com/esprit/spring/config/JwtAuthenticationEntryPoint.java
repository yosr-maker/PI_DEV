package com.esprit.spring.config;

import java.io.IOException;
import java.io.Serializable;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.security.core.AuthenticationException;



@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,AuthenticationException authException) throws IOException {
     response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}

}
 //