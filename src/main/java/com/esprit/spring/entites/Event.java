 package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private String hour;
	@Column(name="Status")
	private Boolean Status;
	private float goal;
	private float collAmount;
	private int placesNbr;
	private int participantsNbr;
	private float ticketPrice;

	private String location;
	private String poster;
	private int views;

	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idJackpot")
	private Jackpot jackpot;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
	private List<Participation> participation;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
	private List <Publicity> publicity;
	

	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
	private List<Contribution> contribution;
	
	public List<Contribution> getContribution() {
		return contribution;
	}


	public void setContribution(List<Contribution> contribution) {
		this.contribution = contribution;
	}


	public List<Publicity> getPublicity() {
		return publicity;
	}


	public void setPublicity(List<Publicity> publicity) {
		this.publicity = publicity;
	}


	public List<Participation> getParticipation() {
		return participation;
	}


	public void setParticipation(List<Participation> participation) {
		this.participation = participation;
	}


	public String getHour() {
		return hour;
	}


	public void setHour(String hour) {
		this.hour = hour;
	}


	public float getGoal() {
		return goal;
	}


	public void setGoal(float goal) {
		this.goal = goal;
	}


	public float getCollAmount() {
		return collAmount;
	}


	public void setCollAmount(float collAmount) {
		this.collAmount = collAmount;
	}


	public int getPlacesNbr() {
		return placesNbr;
	}


	public void setPlacesNbr(int placesNbr) {
		this.placesNbr = placesNbr;
	}


	public int getParticipantsNbr() {
		return participantsNbr;
	}


	public void setParticipantsNbr(int participantsNbr) {
		this.participantsNbr = participantsNbr;
	}


	public float getTicketPrice() {
		return ticketPrice;
	}


	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


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





	public Event(Long idEvent, EventCategory category, String name, String description, Date dateEvent, String hour,
			Boolean status, float goal, float collAmount, int placesNbr, int participantsNbr, float ticketPrice,
			String location, String poster, int views, Jackpot jackpot) {
		super();
		this.idEvent = idEvent;
		this.category = category;
		this.name = name;
		this.description = description;
		this.dateEvent = dateEvent;
		this.hour = hour;
		Status = status;
		this.goal = goal;
		this.collAmount = collAmount;
		this.placesNbr = placesNbr;
		this.participantsNbr = participantsNbr;
		this.ticketPrice = ticketPrice;
		this.location = location;
		this.poster = poster;
		this.views = views;
		this.jackpot = jackpot;
	}


	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

