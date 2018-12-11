package ch.hearc.clientsservice.domaine;

public class Client {
	
	private String nom;
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", identifiant=" + identifiant + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		return true;
	}

	private String prenom;
	private IdentifiantClient identifiant;

	private Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = IdentifiantClient.nouveau();
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public IdentifiantClient getIdentifiant() {
		return identifiant;
	}

	public static Client nouveau (String nom, String prenom) {
		Client client = new Client(nom, prenom);
		return client;
	}
}
