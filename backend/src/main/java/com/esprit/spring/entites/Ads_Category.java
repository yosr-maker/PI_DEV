package com.esprit.spring.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_ADS_CATEGORY")

public class Ads_Category implements Serializable {

	
	 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ads_category_id")
	private int ads_category_id;
	
	
	@Column(name="Name")
	private String Name ;
	
	@OneToOne(mappedBy="ads_category")
    @JoinColumn(name = "adId")
	private Ad ad;
	


	
	public Ads_Category(int ads_category_id, String name, Ad ad) {
		super();
		this.ads_category_id = ads_category_id;
		Name = name;
		this.ad = ad;
	}


	public int getAds_category_id() {
		return ads_category_id;
	}


	public void setAds_category_id(int ads_category_id) {
		this.ads_category_id = ads_category_id;
	}


	public Ad getAd() {
		return ad;
	}


	public void setAd(Ad ad) {
		this.ad = ad;
	}





	@Override
	public String toString() {
		return "Ads_Category [ads_category_id=" + ads_category_id + ", Name=" + Name + ", ad=" + ad + "]";
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public Ads_Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
