package ch.hearc.clientsservice.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.hearc.clientsservice.domaine.Client;
import ch.hearc.clientsservice.domaine.CompteClient;
import ch.hearc.clientsservice.domaine.repository.ClientRepository;

@Repository
public interface CompteClientH2Repository2 extends CrudRepository<CompteClient, Long> {

	public CompteClient findByClient_Identifiant_Numero(String identifiant);
}
