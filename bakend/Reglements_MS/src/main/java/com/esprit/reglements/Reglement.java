package com.esprit.reglements;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Reglement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;
    private Date dateReglement;

    @Enumerated(EnumType.STRING)
    private ModeReglement mode;

    private Long factureId;
    private String referenceTransaction;
    
    
    
	public Reglement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Reglement(Long id, Double montant, Date dateReglement, ModeReglement mode, Long factureId,
			String referenceTransaction) {
		super();
		this.id = id;
		this.montant = montant;
		this.dateReglement = dateReglement;
		this.mode = mode;
		this.factureId = factureId;
		this.referenceTransaction = referenceTransaction;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Double getMontant() {
		return montant;
	}



	public void setMontant(Double montant) {
		this.montant = montant;
	}



	public Date getDateReglement() {
		return dateReglement;
	}



	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
	}



	public ModeReglement getMode() {
		return mode;
	}



	public void setMode(ModeReglement mode) {
		this.mode = mode;
	}



	public Long getFactureId() {
		return factureId;
	}



	public void setFactureId(Long factureId) {
		this.factureId = factureId;
	}



	public String getReferenceTransaction() {
		return referenceTransaction;
	}



	public void setReferenceTransaction(String referenceTransaction) {
		this.referenceTransaction = referenceTransaction;
	}



	@Override
	public String toString() {
		return "Reglement [id=" + id + ", montant=" + montant + ", dateReglement=" + dateReglement + ", mode=" + mode
				+ ", factureId=" + factureId + ", referenceTransaction=" + referenceTransaction + "]";
	}
    
    
    

}
