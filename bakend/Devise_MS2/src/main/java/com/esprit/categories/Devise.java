package com.esprit.categories;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Devise {
    @Id
    private String code; // EUR, USD, MAD...
    private String nom;
    private Double tauxChange;
    private LocalDateTime dateMaj;
    
    
    
    
	public Devise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Devise(String code, String nom, Double tauxChange, LocalDateTime dateMaj) {
		super();
		this.code = code;
		this.nom = nom;
		this.tauxChange = tauxChange;
		this.dateMaj = dateMaj;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getTauxChange() {
		return tauxChange;
	}
	public void setTauxChange(Double tauxChange) {
		this.tauxChange = tauxChange;
	}
	public LocalDateTime getDateMaj() {
		return dateMaj;
	}
	public void setDateMaj(LocalDateTime dateMaj) {
		this.dateMaj = dateMaj;
	}

    
    
}
