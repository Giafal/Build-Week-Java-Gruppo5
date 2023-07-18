package com.epicode.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Biglietto extends Ticket {
	
	
	private boolean vidimato;
	
	
	public Biglietto() {
		super();
	}


	public Biglietto(LocalDate dataDiEmissione, PuntoDiEmissione luogoEmissione, boolean vidimato) {
		super(dataDiEmissione, luogoEmissione);
		this.vidimato = vidimato;
		
	}


	public boolean isVidimato() {
		return vidimato;
	}


	public void setVidimato(boolean vidimato) {
		this.vidimato = vidimato;
	}


	@Override
	public String toString() {
		return "Biglietto [vidimato=" + vidimato + ", getId()=" + getId() + ", getDataDiEmissione()="
				+ getDataDiEmissione() + ", getLuogoEmissione()=" + getLuogoEmissione() + "]";
	}


	
	
	
	
	
	

}
