package ch.hearc.clientsservice.domaine.command;

import java.math.BigDecimal;

public class CrediteClientCommand {

	private String identifiantClient;
	private BigDecimal montant;
	
	public CrediteClientCommand(String identifiantClient, BigDecimal montant) {
		super();
		this.identifiantClient = identifiantClient;
		this.montant = montant;
	}

	public String getIdentifiantClient() {
		return identifiantClient;
	}

	public BigDecimal getMontant() {
		return montant;
	}
}
