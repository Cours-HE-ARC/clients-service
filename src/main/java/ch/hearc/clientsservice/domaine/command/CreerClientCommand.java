package ch.hearc.clientsservice.domaine.command;

public class CreerClientCommand {

	private String nom;
	private String prenom;
	
	public CreerClientCommand(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
}
