package edu.ucacue.exameninterciclo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import edu.ucacue.exameninterciclo.controlador.Principal;

@SpringBootApplication
public class ExamenintercicloApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contexto = new SpringApplicationBuilder(ExamenintercicloApplication.class)
			    .headless(false)
			    .web(WebApplicationType.NONE)
			    .run(args);
				Principal principal= contexto.getBean(Principal.class);
				principal.interfaz();
	}

}