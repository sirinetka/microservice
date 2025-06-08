package com.esprit.categories.dto;

import java.time.LocalDateTime;

public class ConversionResponse {
    private Double montantOriginal;
    private Double montantConverti;
    private Double taux;
    private String date;

    public ConversionResponse(Double montantOriginal, Double montantConverti, Double taux, LocalDateTime dateMaj) {
        this.montantOriginal = montantOriginal;
        this.montantConverti = montantConverti;
        this.taux = taux;
        this.date = dateMaj.toLocalDate().toString();
    }

	@Override
	public String toString() {
		return "ConversionResponse [montantOriginal=" + montantOriginal + ", montantConverti=" + montantConverti
				+ ", taux=" + taux + ", date=" + date + "]";
	}

	public Double getMontantOriginal() {
		return montantOriginal;
	}

	public void setMontantOriginal(Double montantOriginal) {
		this.montantOriginal = montantOriginal;
	}

	public Double getMontantConverti() {
		return montantConverti;
	}

	public void setMontantConverti(Double montantConverti) {
		this.montantConverti = montantConverti;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
    
    
}
