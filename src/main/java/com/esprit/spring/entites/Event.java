 package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name="Title")
	private String Title;
	
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

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
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


	public Event(Long idEvent, String title, Date dateEvent, Boolean status, Jackpot jackpot) {
		super();
		this.idEvent = idEvent;
		Title = title;
		this.dateEvent = dateEvent;
		Status = status;
		this.jackpot = jackpot;
	}


	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

