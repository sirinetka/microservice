package com.esprit.categories;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
public class DeviseMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviseMsApplication.class, args);
	}
	
	@Autowired
	private DeviseRepository repository;
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save
			
		            if (repository.count() == 0) {
		                List<Devise> devises = List.of(
		                    new Devise("EUR", "Euro", 1.0, LocalDateTime.now()),
		                    new Devise("USD", "Dollar Américain", 1.12, LocalDateTime.now()),
		                    new Devise("MAD", "Dirham Marocain", 10.5, LocalDateTime.now()),
		                    new Devise("GBP", "Livre Sterling", 0.85, LocalDateTime.now()),
		                    new Devise("JPY", "Yen Japonais", 155.0, LocalDateTime.now()),
		                    new Devise("CAD", "Dollar Canadien", 1.35, LocalDateTime.now()),
		                    new Devise("CHF", "Franc Suisse", 0.98,  LocalDateTime.now()),
		                    new Devise("CNY", "Yuan Chinois", 0.41, LocalDateTime.now()),
		                    new Devise("AED", "Dirham des Émirats", 0.82, LocalDateTime.now()),
		                    new Devise("SAR", "Riyal Saoudien", 0.80, LocalDateTime.now()),
		                    new Devise("TRY", "Livre Turque", 0.10, LocalDateTime.now()),
		                    new Devise("NOK", "Couronne Norvégienne", 0.29, LocalDateTime.now()),
		                    new Devise("SEK", "Couronne Suédoise", 0.30, LocalDateTime.now()),
		                    new Devise("DZD", "Dinar Algérien", 0.022, LocalDateTime.now()),
		                    new Devise("LYD", "Dinar Libyen", 0.60, LocalDateTime.now()),
		                    new Devise("EGP", "Livre Égyptienne", 0.097, LocalDateTime.now()),
		                    new Devise("KWD", "Dinar Koweïtien", 9.9, LocalDateTime.now()),
		                    new Devise("QAR", "Riyal Qatari", 0.83, LocalDateTime.now()),
		                    new Devise("BHD", "Dinar Bahreïni", 7.9, LocalDateTime.now())
		                		
		                		);

		                
		                repository.saveAll(devises);
		                System.out.println("✅ Devises initialisées !");
		            } else {
		                System.out.println("ℹ️ Devises déjà présentes, initialisation ignorée.");
		            }

		            repository.findAll().forEach(System.out::println);
		        };
		};
		
	}
	


