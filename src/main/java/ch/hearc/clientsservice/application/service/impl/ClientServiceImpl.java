package ch.hearc.clientsservice.application.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.clientsservice.application.service.ClientService;
import ch.hearc.clientsservice.domaine.Client;
import ch.hearc.clientsservice.domaine.CompteClient;
import ch.hearc.clientsservice.domaine.command.CrediteClientCommand;
import ch.hearc.clientsservice.domaine.command.CreerClientCommand;
import ch.hearc.clientsservice.domaine.command.DebiteClientCommand;
import ch.hearc.clientsservice.infrastructure.repository.ClientH2Repository;
import ch.hearc.clientsservice.infrastructure.repository.CompteClientH2Repository2;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientH2Repository repository;
	
	@Autowired
	ClientH2Repository clientRepository;
	
	@Autowired
	CompteClientH2Repository2 compteRepository;
	
	@Override
	@Transactional
	public List<Client> getAllClients() {
		
		List<Client> clients = new ArrayList<>();
		
		clientRepository.findAll().forEach(clients::add);
		
		return clients;
		
		
	}
	
	@Override
	@Transactional
	public List<CompteClient> getAllCompteClients() {
		
		List<CompteClient> compteClients = new ArrayList<>();
		
		compteRepository.findAll().forEach(compteClients::add);
		
		return compteClients;
		
		
	}
	
	@Override
	@Transactional
	public String creerNouveauClient(CreerClientCommand creerClientCommand) {
		
		Client client = Client.nouveau(creerClientCommand.getNom(), creerClientCommand.getPrenom());
		System.out.println(client);
		
		CompteClient ccli = CompteClient.nouveau(client, BigDecimal.ZERO);
		ccli = compteRepository.save(ccli);
		
		return ccli.getClient().getIdentifiant().getNumero();
		
	}
	
	@Override
	@Transactional
	public CompteClient getCompteClientByIdentifiant(String identifiant) {
		
		CompteClient compteClient =  compteRepository.findByClient_Identifiant_Numero(identifiant);
		compteClient.getClient();
		return compteClient;
		
	}
	
	@Override
	@Transactional
	public void debite(DebiteClientCommand debiteClientCommand) {
		
		CompteClient compteClient =  compteRepository.findByClient_Identifiant_Numero(debiteClientCommand.getIdentifiantClient());
		
		compteClient.debite(debiteClientCommand.getMontant());
		
		compteRepository.save(compteClient);
		
		
	}
	
	@Override
	@Transactional
	public void credite(CrediteClientCommand crediteClientCommand) {
		
		CompteClient compteClient =  compteRepository.findByClient_Identifiant_Numero(crediteClientCommand.getIdentifiantClient());
		
		compteClient.credite(crediteClientCommand.getMontant());
		
		compteRepository.save(compteClient);
		
		
	}
	
	

}
