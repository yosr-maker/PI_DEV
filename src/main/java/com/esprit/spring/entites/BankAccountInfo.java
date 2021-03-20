package com.esprit.spring.entites;

public class BankAccountInfo {
	 
	   private Long id;
	   private String fullName;
	   private double balance;
	 
	   public BankAccountInfo() {
	 
	   }
	 
	   public BankAccountInfo(Long id, String fullName, double balance) {
	      this.id = id;
	      this.fullName = fullName;
	      this.balance = balance;
	   }
	 
	   public Long getId() {
	      return id;
	   }
	 
	   public void setId(Long id) {
	      this.id = id;
	   }
	 
	   public String getFullName() {
	      return fullName;
	   }
	 
	   public void setFullName(String fullName) {
	      this.fullName = fullName;
	   }
	 
	   public double getBalance() {
	      return balance;
	   }
	 
	   public void setBalance(double balance) {
	      this.balance = balance;
	   }
	}