package ch.hearc.clientsservice.domaine;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void whenInstantcieClient_thenAllFieldsMusstBeCorrect() {
		Client c = Client.nouveau("Seb", "Chèvre");
		System.out.println(c);
		
		assertFalse("Le numero identifiant ne doit pas etre vide ou null",c.getIdentifiant().getNumero().isEmpty());
	
		Client c2 =  Client.nouveau("Seb", "Chèvre");
		System.out.println(c2);
		assertNotEquals("Les deux client ne sont pas egaux, uniquement identifiant",c,c2);
	}

}
