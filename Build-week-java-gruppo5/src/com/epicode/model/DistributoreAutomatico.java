package com.epicode.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.epicode.enumaration.Stato;

@Entity
public class DistributoreAutomatico extends PuntoDiEmissione {
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
	private Integer bigliettiDA;
	private Integer abbonamentiDA;
	
	
	
	
	public DistributoreAutomatico() {
		super();
	}


	public DistributoreAutomatico( Stato stato, Integer biglietti, Integer abbonamenti) {
		this.stato = stato;
		this.bigliettiDA = biglietti;
		this.abbonamentiDA = abbonamenti;
	}


	public Stato getStato() {
		return stato;
	}


	public void setStato(Stato stato) {
		this.stato = stato;
	}


	public Integer getBiglietti() {
		return bigliettiDA;
	}


	public void setBiglietti(Integer biglietti) {
		this.bigliettiDA = biglietti;
	}


	public Integer getAbbonamenti() {
		return abbonamentiDA;
	}


	public void setAbbonamenti(Integer abbonamenti) {
		this.abbonamentiDA = abbonamenti;
	}


	@Override
	public String toString() {
		return "DistributoreAutomatico [stato=" + stato + ", biglietti=" + bigliettiDA + ", abbonamenti="
				+ abbonamentiDA + "]";
	}
	
	

}
