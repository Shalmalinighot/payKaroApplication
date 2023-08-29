package com.cg.bankdetails.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserBankDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;

	@Column(unique=true)
	private long accountNumber;
	private String accountHolderName;
	private String bankName;
	private String ifscCode;
    private String contactNumber;
	private int userId;
  
   
	

}
	
	


