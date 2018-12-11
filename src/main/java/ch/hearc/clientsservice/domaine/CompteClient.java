package ch.hearc.clientsservice.domaine;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ch.hearc.clientsservice.domaine.exception.BusinessException;

@Entity
@Table(name="compte_client")
public class CompteClient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private BigDecimal solde;
	
	@OneToOne(fetch = FetchType.EAGER)
    @MapsId
	private Client client;
	
	CompteClient(){}
	
	private CompteClient(Client client, BigDecimal soldeInitial) {
		this.solde = soldeInitial;
		this.client = client;
	}
	
	
	public void debite(BigDecimal montant) {
		
		if(solde.compareTo(montant) > 0) {
			solde = solde.subtract(montant);
		}else {
			throw new BusinessException(String.format("The solde [%s] is insuficient",solde.toPlainString()));
		}
	}
	
	
	public void credite(BigDecimal montant) {
		
		solde = solde.add(montant);
	}
	
	@Override
	public String toString() {
		return "CompteClient [id=" + id + ", solde=" + solde + ", client=" + client + "]";
	}

	public static CompteClient nouveau (Client client, BigDecimal soldeInitial) {
		return new CompteClient(client, soldeInitial);
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public Client getClient() {
		return client;
	}
	

}
