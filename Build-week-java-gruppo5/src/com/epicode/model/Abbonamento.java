package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.epicode.enumaration.Validita;

@Entity
public class Abbonamento extends Ticket {
	
	
	@Enumerated(EnumType.STRING)
	private Validita validita;
	@OneToOne
	private Utente titolare;
	
	
	
	
	public Abbonamento() {
		super();
	}



	public Abbonamento(LocalDate dataDiEmissione, PuntoDiEmissione luogoEmissione, Validita validita, Utente titolare) {
		super(dataDiEmissione, luogoEmissione);
		this.validita = validita;
		this.titolare = titolare;
		
	}



	public Validita getValidita() {
		return validita;
	}



	public void setValidita(Validita validita) {
		this.validita = validita;
	}



	public Utente getTitolare() {
		return titolare;
	}



	public void setTitolare(Utente titolare) {
		this.titolare = titolare;
	}



	@Override
	public String toString() {
		return "Abbonamento [validita=" + validita + ", titolare=" + titolare + ", getId()=" + getId()
				+ ", getDataDiEmissione()=" + getDataDiEmissione() + ", getLuogoEmissione()=" + getLuogoEmissione()
				+ "]";
	}



	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
