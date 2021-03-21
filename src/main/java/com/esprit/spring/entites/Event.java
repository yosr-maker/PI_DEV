 package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EVENT")

public class Event  implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idEvent")
	private  Long idEvent ;
	
	@Enumerated(EnumType.STRING)
	private EventCategory category;
	
	@Column(name="name")
	private String name;
	

	@Column(name="description")
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dateEvent;
	
	@Column(name="Status")
	private Boolean Status;
	
	@ManyToOne
    @JoinColumn(name = "idJackpot")
	private Jackpot jackpot;
	
	
	public Long getIdEvent() {
		return idEvent;
	}


	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	
	public EventCategory getCategory() {
		return category;
	}


	public void setCategory(EventCategory category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

	public Jackpot getJackpot() {
		return jackpot;
	}


	public void setJackpot(Jackpot jackpot) {
		this.jackpot = jackpot;
	}




	public Event(Long idEvent, String name, Date dateEvent, Boolean status, Jackpot jackpot) {
		super();
		this.idEvent = idEvent;
		this.name = name;
		this.dateEvent = dateEvent;
		Status = status;
		this.jackpot = jackpot;
	}


	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

