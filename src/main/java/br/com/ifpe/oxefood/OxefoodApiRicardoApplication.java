package br.com.ifpe.oxefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing /* Adicionado - 04/11 */
public class OxefoodApiRicardoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxefoodApiRicardoApplication.class, args);
		
	}

}
