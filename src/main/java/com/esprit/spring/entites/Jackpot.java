 package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="JACKPOT")

 
public class Jackpot  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idJackpot")
	private  Long idJackpot ;
	
	private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Client client;
	
	
	@OneToMany(mappedBy="jackpot")
	private List<Event>event;




	public Long getIdJackpot() {
		return idJackpot;
	}




	public void setIdJackpot(Long idJackpot) {
		this.idJackpot = idJackpot;
	}




	


	public Client getClient() {
		return client;
	}




	public void setClient(Client client) {
		this.client = client;
	}




	public List<Event> getEvent() {
		return event;
	}




	public void setEvent(List<Event> event) {
		this.event = event;
	}




	




	public Jackpot() {
		super();
		// TODO Auto-generated constructor stub
	}








	@Override
	public String toString() {
		return "Jackpot [idJackpot=" + idJackpot + ", fromAccountId=" + fromAccountId + ", toAccountId=" + toAccountId
				+ ", amount=" + amount + ", client=" + client + ", event=" + event + "]";
	}




	public Long getFromAccountId() {
		return fromAccountId;
	}




	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}




	public Long getToAccountId() {
		return toAccountId;
	}




	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}




	public Double getAmount() {
		return amount;
	}




	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
	
}

