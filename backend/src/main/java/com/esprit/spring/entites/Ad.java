
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

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="T_AD")
public class Ad  implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "adId")
	private int adId;
	
	@Temporal(TemporalType.DATE)
	private Date beginningDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name="canalOfTransmission")
	private String CanalOfTransmission ;
	
	@Column(name="targetView")
	private String targetView ;
	
	@Column(name="Views")
	private String Views ;
	

	@OneToOne
	Ads_Category ads_category;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private Product product;
	
	
	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public Date getBeginningDate() {
		return beginningDate;
	}

	public void setBeginningDate(Date beginningDate) {
		this.beginningDate = beginningDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCanalOfTransmission() {
		return CanalOfTransmission;
	}

	public void setCanalOfTransmission(String canalOfTransmission) {
		CanalOfTransmission = canalOfTransmission;
	}

	public String getTargetView() {
		return targetView;
	}

	public void setTargetView(String targetView) {
		this.targetView = targetView;
	}

	public String getViews() {
		return Views;
	}

	public void setViews(String views) {
		Views = views;
	}

	
	public Ads_Category getAds_category() {
		return ads_category;
	}

	public void setAds_category(Ads_Category ads_category) {
		this.ads_category = ads_category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

