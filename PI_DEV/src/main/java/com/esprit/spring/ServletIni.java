package com.esprit.spring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



	public class ServletIni extends SpringBootServletInitializer {

		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(PiDevApplication.class);
		}
	}

