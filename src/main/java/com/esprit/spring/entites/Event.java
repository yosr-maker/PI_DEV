 package com.esprit.spring.entites;
 import java.io.Serializable;
 import java.sql.Date;
 import java.util.List;


 import javax.persistence.CascadeType;
 import javax.persistence.Entity;
 import javax.persistence.EnumType;
 import javax.persistence.Enumerated;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.OneToMany;
 import javax.persistence.OneToOne;

 @Entity
 public class Event implements Serializable {
 	
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;
 	
 	@Id
 	@GeneratedValue( strategy = GenerationType.IDENTITY )
 	private Long id;
 	@Enumerated(EnumType.STRING)
 	private EventCategory category;
 	private String name;
 	private String description;
 	private float goal;
 	private float collAmount;
 	private int placesNbr;
 	private int participantsNbr;
 	private float ticketPrice;
 	private Date date;
 	private String hour;
 	private String location;
 	private String poster;
 	private int views;
 	private boolean status;
 	@OneToOne(cascade=CascadeType.ALL)
 	@JoinColumn(name="jackpot_id")
 	private Jackpot jackpot;
 	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
 	private List<Notification> notification;
 	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
 	private List <Publicity> publicity;
 	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
 	private List<Participation> participation;
 	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
 	private List<Contribution> contribution;
 	
 	public Event() {
 		super();
 		// TODO Auto-generated constructor stub
 	}

 	public Event(Long id, EventCategory category, String name, String description, float goal, float collAmount,
 			int placesNbr, int participantsNbr, float ticketPrice, Date date, String hour, String location,
 			String poster, int views, boolean status, Jackpot jackpot, List<Notification> notification,
 			List<Publicity> publicity, List<Participation> participation, List<Contribution> contribution) {
 		super();
 		this.id = id;
 		this.category = category;
 		this.name = name;
 		this.description = description;
 		this.goal = goal;
 		this.collAmount = collAmount;
 		this.placesNbr = placesNbr;
 		this.participantsNbr = participantsNbr;
 		this.ticketPrice = ticketPrice;
 		this.date = date;
 		this.hour = hour;
 		this.location = location;
 		this.poster = poster;
 		this.views = views;
 		this.status = status;
 		this.jackpot = jackpot;
 		this.notification = notification;
 		this.publicity = publicity;
 		this.participation = participation;
 		this.contribution = contribution;
 	}

 	public Long getId() {
 		return id;
 	}

 	public void setId(Long id) {
 		this.id = id;
 	}

 	public EventCategory getCategory() {
 		return category;
 	}

 	public void setCategory(EventCategory category) {
 		this.category = category;
 	}

 	public String getName() {
 		return name;
 	}

 	public void setName(String name) {
 		this.name = name;
 	}

 	public String getDescription() {
 		return description;
 	}

 	public void setDescription(String description) {
 		this.description = description;
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

 	public Date getDate() {
 		return date;
 	}

 	public void setDate(Date date) {
 		this.date = date;
 	}

 	public String getHour() {
 		return hour;
 	}

 	public void setHour(String hour) {
 		this.hour = hour;
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

 	public boolean isStatus() {
 		return status;
 	}

 	public void setStatus(boolean status) {
 		this.status = status;
 	}

 	public Jackpot getJackpot() {
 		return jackpot;
 	}

 	public void setJackpot(Jackpot jackpot) {
 		this.jackpot = jackpot;
 	}

 	public List<Notification> getNotification() {
 		return notification;
 	}

 	public void setNotification(List<Notification> notification) {
 		this.notification = notification;
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

 	public List<Contribution> getContribution() {
 		return contribution;
 	}

 	public void setContribution(List<Contribution> contribution) {
 		this.contribution = contribution;
 	}

 	@Override
 	public int hashCode() {
 		final int prime = 31;
 		int result = 1;
 		result = prime * result + ((category == null) ? 0 : category.hashCode());
 		result = prime * result + Float.floatToIntBits(collAmount);
 		result = prime * result + ((contribution == null) ? 0 : contribution.hashCode());
 		result = prime * result + ((date == null) ? 0 : date.hashCode());
 		result = prime * result + ((description == null) ? 0 : description.hashCode());
 		result = prime * result + Float.floatToIntBits(goal);
 		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
 		result = prime * result + ((id == null) ? 0 : id.hashCode());
 		result = prime * result + ((jackpot == null) ? 0 : jackpot.hashCode());
 		result = prime * result + ((location == null) ? 0 : location.hashCode());
 		result = prime * result + ((name == null) ? 0 : name.hashCode());
 		result = prime * result + ((notification == null) ? 0 : notification.hashCode());
 		result = prime * result + participantsNbr;
 		result = prime * result + ((participation == null) ? 0 : participation.hashCode());
 		result = prime * result + placesNbr;
 		result = prime * result + ((poster == null) ? 0 : poster.hashCode());
 		result = prime * result + ((publicity == null) ? 0 : publicity.hashCode());
 		result = prime * result + (status ? 1231 : 1237);
 		result = prime * result + Float.floatToIntBits(ticketPrice);
 		result = prime * result + views;
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
 		Event other = (Event) obj;
 		if (category != other.category)
 			return false;
 		if (Float.floatToIntBits(collAmount) != Float.floatToIntBits(other.collAmount))
 			return false;
 		if (contribution == null) {
 			if (other.contribution != null)
 				return false;
 		} else if (!contribution.equals(other.contribution))
 			return false;
 		if (date == null) {
 			if (other.date != null)
 				return false;
 		} else if (!date.equals(other.date))
 			return false;
 		if (description == null) {
 			if (other.description != null)
 				return false;
 		} else if (!description.equals(other.description))
 			return false;
 		if (Float.floatToIntBits(goal) != Float.floatToIntBits(other.goal))
 			return false;
 		if (hour == null) {
 			if (other.hour != null)
 				return false;
 		} else if (!hour.equals(other.hour))
 			return false;
 		if (id == null) {
 			if (other.id != null)
 				return false;
 		} else if (!id.equals(other.id))
 			return false;
 		if (jackpot == null) {
 			if (other.jackpot != null)
 				return false;
 		} else if (!jackpot.equals(other.jackpot))
 			return false;
 		if (location == null) {
 			if (other.location != null)
 				return false;
 		} else if (!location.equals(other.location))
 			return false;
 		if (name == null) {
 			if (other.name != null)
 				return false;
 		} else if (!name.equals(other.name))
 			return false;
 		if (notification == null) {
 			if (other.notification != null)
 				return false;
 		} else if (!notification.equals(other.notification))
 			return false;
 		if (participantsNbr != other.participantsNbr)
 			return false;
 		if (participation == null) {
 			if (other.participation != null)
 				return false;
 		} else if (!participation.equals(other.participation))
 			return false;
 		if (placesNbr != other.placesNbr)
 			return false;
 		if (poster == null) {
 			if (other.poster != null)
 				return false;
 		} else if (!poster.equals(other.poster))
 			return false;
 		if (publicity == null) {
 			if (other.publicity != null)
 				return false;
 		} else if (!publicity.equals(other.publicity))
 			return false;
 		if (status != other.status)
 			return false;
 		if (Float.floatToIntBits(ticketPrice) != Float.floatToIntBits(other.ticketPrice))
 			return false;
 		if (views != other.views)
 			return false;
 		return true;
 	}

 	@Override
 	public String toString() {
 		return "Event [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
 				+ ", goal=" + goal + ", collAmount=" + collAmount + ", placesNbr=" + placesNbr + ", participantsNbr="
 				+ participantsNbr + ", ticketPrice=" + ticketPrice + ", date=" + date + ", hour=" + hour + ", location="
 				+ location + ", poster=" + poster + ", views=" + views + ", status=" + status + ", jackpot=" + jackpot
 				+ ", notification=" + notification + ", publicity=" + publicity + ", participation=" + participation
 				+ ", contribution=" + contribution + "]";
 	}
 	
 	
 	}

