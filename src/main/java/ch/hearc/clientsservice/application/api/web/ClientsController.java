package ch.hearc.clientsservice.application.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.hearc.clientsservice.application.service.ClientService;
import ch.hearc.clientsservice.domaine.Client;
import ch.hearc.clientsservice.domaine.CompteClient;
import ch.hearc.clientsservice.domaine.command.CrediteClientCommand;
import ch.hearc.clientsservice.domaine.command.DebiteClientCommand;

@RestController
@RequestMapping("/clients")
public class ClientsController {

	@Autowired
	ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> getAllClients () {
		
		return ResponseEntity.ok(clientService.getAllClients());
		
	}
	
	@GetMapping("comptes")
	public ResponseEntity<List<CompteClient>> getAllCompteClients () {
		
		return ResponseEntity.ok(clientService.getAllCompteClients());
		
	}
	
	@PostMapping("debit")
	public ResponseEntity<CompteClient> debitCLient (
			@RequestBody DebiteClientCommand debiteClientCommand ) {
		
		clientService.debite(debiteClientCommand);
		
		return ResponseEntity.ok(clientService.getCompteClientByIdentifiant(debiteClientCommand.getIdentifiantClient()));
		
	}
	
	@PostMapping("credit")
	public ResponseEntity<CompteClient> creditCLient (
			@RequestBody CrediteClientCommand crediteClientCommand ) {
		
		clientService.credite(crediteClientCommand);
		
		return ResponseEntity.ok(clientService.getCompteClientByIdentifiant(crediteClientCommand.getIdentifiantClient()));
		
	}
}
