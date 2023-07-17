package com.epicode.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Biglietto extends Ticket {
	
	
	private boolean vidimato;
	@OneToOne
	private PuntoDiEmissione luogoEmissione;
	
	public Biglietto() {
		super();
	}
	
	public Biglietto(LocalDate dataDiEmissione, boolean vidimato, PuntoDiEmissione luogoEmissione) {
		super(dataDiEmissione);
		this.vidimato = vidimato;
		this.luogoEmissione = luogoEmissione;
	}
	public boolean isVidimato() {
		return vidimato;
	}
	public void setVidimato(boolean vidimato) {
		this.vidimato = vidimato;
	}
	public PuntoDiEmissione getLuogoEmissione() {
		return luogoEmissione;
	}
	public void setLuogoEmissione(PuntoDiEmissione luogoEmissione) {
		this.luogoEmissione = luogoEmissione;
	}

	@Override
	public String toString() {
		return "Biglietto [vidimato=" + vidimato + ", luogoEmissione=" + luogoEmissione + "]";
	}
	
	
	
	

}
