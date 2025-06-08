package com.esprit.categories.dto;

public class ConversionRequest {
    private Double montant;
    private String deviseSource;
    private String deviseCible;
	public Double getMontant() {
		return montant;
	}
	
	
	
	
	@Override
	public String toString() {
		return "ConversionRequest [montant=" + montant + ", deviseSource=" + deviseSource + ", deviseCible="
				+ deviseCible + "]";
	}




	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getDeviseSource() {
		return deviseSource;
	}
	public void setDeviseSource(String deviseSource) {
		this.deviseSource = deviseSource;
	}
	public String getDeviseCible() {
		return deviseCible;
	}
	public void setDeviseCible(String deviseCible) {
		this.deviseCible = deviseCible;
	}
    
    
    
}
