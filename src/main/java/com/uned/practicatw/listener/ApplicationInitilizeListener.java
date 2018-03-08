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
import com.uned.practicatw.utils.Util;

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
		Persona salaDeCine = new Persona(Util.SALA_DE_CINE, "Sala de cine", 25);
		persons.add(salaDeCine);
		Persona anonima = new Persona(Util.USUARIO_NO_REGISTRADO, "Usuario no registrado", 25);
		persons.add(anonima);
		for (int i = 2; i <= itemCount; i++) {
			
			Persona p = new Persona();
			p.setEdad((i % 100) + 1);
			p.setNombre("name" + i);
			p.setPerfil(Util.CLIENTE);
			persons.add(p);
			if ((i % chunkSize) == 0) {
				personRepository.save(persons);
				persons.clear();
			}
		}
		personRepository.save(persons);

	}

}
