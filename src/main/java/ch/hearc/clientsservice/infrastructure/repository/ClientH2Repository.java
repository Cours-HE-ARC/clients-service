package ch.hearc.clientsservice.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.hearc.clientsservice.domaine.Client;
import ch.hearc.clientsservice.domaine.repository.ClientRepository;

@Repository
public interface ClientH2Repository extends CrudRepository<Client, Long> {

	public Client findByIdentifiant(String identifiant);
}
