package com.epicode.model;

import javax.persistence.Entity;


@Entity
public class RivenditoreAutorizzato extends PuntoDiEmissione  {
	
	
	private Integer bigliettiRA;
	private Integer abbonamentiRA;
	
	
	
	
	public RivenditoreAutorizzato() {
		super();
	}


	public RivenditoreAutorizzato(Integer biglietti, Integer abbonamenti) {
		this.bigliettiRA = biglietti;
		this.abbonamentiRA = abbonamenti;
	}


	public Integer getBiglietti() {
		return bigliettiRA;
	}


	public void setBiglietti(Integer biglietti) {
		this.bigliettiRA = biglietti;
	}


	public Integer getAbbonamenti() {
		return abbonamentiRA;
	}


	public void setAbbonamenti(Integer abbonamenti) {
		this.abbonamentiRA = abbonamenti;
	}


	@Override
	public String toString() {
		return "RivenditoreAutorizzato [biglietti=" + bigliettiRA + ", abbonamenti=" + abbonamentiRA + "]";
	}
	
	

}
