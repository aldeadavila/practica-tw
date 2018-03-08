package com.uned.practicatw.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.uned.practicatw.entity.Perfil;
import com.uned.practicatw.entity.Persona;
import com.uned.practicatw.repository.PerfilRepository;
import com.uned.practicatw.repository.PersonaRepository;

public class ApplicationInitilizeListener implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationInitilizeListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOGGER.debug("initializing..");
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());

		 incluirPerfilesEnBBDD(ctx);
		incluirPersonasEnBBDD(ctx);
		

	}

	private void incluirPerfilesEnBBDD(WebApplicationContext ctx) {
		PerfilRepository perfilRepository = ctx.getBean(PerfilRepository.class);
		perfilRepository.deleteAll();
		perfilRepository.save(new Perfil(1, "USUARIO NO REGISTRADO"));
		perfilRepository.save(new Perfil(2, "CLIENTE"));
		perfilRepository.save(new Perfil(3, "SALA DE CINE"));
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	private void incluirPersonasEnBBDD(WebApplicationContext ctx) {
		PersonaRepository personRepository = ctx.getBean(PersonaRepository.class);
		personRepository.deleteAll();
		List<Persona> persons = new ArrayList<Persona>();

		int itemCount = 100;
		int chunkSize = 25;
		for (int i = 1; i <= itemCount; i++) {
			Persona p = new Persona();
			p.setAge((i % 100) + 1);
			p.setName("name" + i);
			persons.add(p);
			if ((i % chunkSize) == 0) {
				personRepository.save(persons);
				persons.clear();
			}
		}
		personRepository.save(persons);

	}

}
