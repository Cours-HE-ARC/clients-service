package ch.hearc.clientsservice.domaine;

import java.util.UUID;

public class IdentifiantClient {
	
	private String numero;
	
	private IdentifiantClient(String numero) {
		this.numero = numero;
	}

	public static IdentifiantClient nouveau() {
		String numero = UUID.randomUUID().toString();
		return new IdentifiantClient(numero);
	}

	@Override
	public String toString() {
		return "IdentifiantClient [numero=" + numero + "]";
	}

	public String getNumero() {
		return numero;
	}
	
	

}
