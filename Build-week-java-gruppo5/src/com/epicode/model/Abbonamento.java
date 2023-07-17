package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import com.epicode.enumaration.Validita;

@Entity
public class Abbonamento extends Ticket {
	
	
	@Enumerated(EnumType.STRING)
	private Validita validita;
	@OneToOne
	private Utente titolare;
	@OneToOne
	private PuntoDiEmissione luogoEmissione;
	
	
	public Abbonamento() {
		super();
	}
	
	
	public Abbonamento(LocalDate dataDiEmissione, Validita validita, Utente titolare, PuntoDiEmissione luogoEmissione) {
		super(dataDiEmissione);
		this.validita = validita;
		this.titolare = titolare;
		this.luogoEmissione = luogoEmissione;
		
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


	public PuntoDiEmissione getLuogoEmissione() {
		return luogoEmissione;
	}


	public void setLuogoEmissione(PuntoDiEmissione luogoEmissione) {
		this.luogoEmissione = luogoEmissione;
	}


	@Override
	public String toString() {
		return "Abbonamento [validita=" + validita + ", titolare=" + titolare + ", luogoEmissione=" + luogoEmissione
				+ "]";
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
