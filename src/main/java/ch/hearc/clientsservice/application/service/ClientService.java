package ch.hearc.clientsservice.application.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import ch.hearc.clientsservice.domaine.Client;
import ch.hearc.clientsservice.domaine.CompteClient;
import ch.hearc.clientsservice.domaine.command.CrediteClientCommand;
import ch.hearc.clientsservice.domaine.command.CreerClientCommand;
import ch.hearc.clientsservice.domaine.command.DebiteClientCommand;

@Service
public interface ClientService {

	String creerNouveauClient(CreerClientCommand creerClientCommand);

	CompteClient getCompteClientByIdentifiant(String identifiant);

	
	void debite(DebiteClientCommand debiteClientCommand);

	void credite(CrediteClientCommand crediteClientCommand);

}
