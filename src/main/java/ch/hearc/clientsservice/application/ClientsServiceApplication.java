package ch.hearc.clientsservice.application;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import ch.hearc.clientsservice.application.service.ClientService;
import ch.hearc.clientsservice.domaine.Client;
import ch.hearc.clientsservice.domaine.CompteClient;
import ch.hearc.clientsservice.domaine.command.CrediteClientCommand;
import ch.hearc.clientsservice.domaine.command.CreerClientCommand;
import ch.hearc.clientsservice.domaine.command.DebiteClientCommand;
import ch.hearc.clientsservice.infrastructure.repository.ClientH2Repository;
import ch.hearc.clientsservice.infrastructure.repository.CompteClientH2Repository2;

@SpringBootApplication
@EnableJpaRepositories(basePackages="ch.hearc.clientsservice.infrastructure.repository")
@EntityScan(basePackages="ch.hearc.clientsservice.domaine")
public class ClientsServiceApplication {

	
	
	@Autowired
	ClientService service;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientsServiceApplication.class, args);
		
		
	}
	
	
	@PostConstruct
	public void test () {
		
		CreerClientCommand command = new CreerClientCommand("Seb", "Chèvre");
		
		String newClientIdentifiant = service.creerNouveauClient(command);
		
		CompteClient cc = load(newClientIdentifiant);
		
		System.out.println(cc);
		
		CrediteClientCommand credit = new CrediteClientCommand(cc.getClient().getIdentifiant().getNumero(), new BigDecimal(1500));
		
		service.credite(credit);
		
		cc = load(newClientIdentifiant);
		
		System.out.println(cc);
		
		DebiteClientCommand debit = new DebiteClientCommand(cc.getClient().getIdentifiant().getNumero(), new BigDecimal(1000));
		
		service.debite(debit);
		
		cc = load(newClientIdentifiant);
		
		System.out.println(cc);
		
	}
	
	
	public CompteClient load(String identifiant) {
		return  service.getCompteClientByIdentifiant(identifiant);
	}
	
}
