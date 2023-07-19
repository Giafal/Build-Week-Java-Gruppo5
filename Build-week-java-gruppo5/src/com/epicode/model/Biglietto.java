package com.epicode.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "ticketVidimatiPerData", query = "SELECT t FROM Biglietto t WHERE t.dataVidimazione > :startDate AND t.dataVidimazione < :endDate")
@NamedQuery(name = "ticketVidimatiPerMezzo", query = "SELECT t FROM Biglietto t WHERE t.mezzo.id = :id_mezzo AND t.vidimato = TRUE")
public class Biglietto extends Ticket {
	
	
	private boolean vidimato;
	@OneToOne
	private Mezzo mezzo;
	private LocalDate dataVidimazione;
	
	public Biglietto() {
		super();
	}


	public Biglietto(LocalDate dataDiEmissione, PuntoDiEmissione luogoEmissione, boolean vidimato) {
		super(dataDiEmissione, luogoEmissione);
		this.vidimato = vidimato;	
	}
	
	public Biglietto(LocalDate dataDiEmissione, PuntoDiEmissione luogoEmissione, boolean vidimato, Mezzo mezzo, LocalDate dataVidimazione) {
		super(dataDiEmissione, luogoEmissione);
		this.vidimato = vidimato;
		this.mezzo = mezzo;
		this.dataVidimazione = dataVidimazione;
	}
	
	public Mezzo getMezzo() {
		return mezzo;
	}


	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}


	public LocalDate getDataVidimazione() {
		return dataVidimazione;
	}


	public void setDataVidimazione(LocalDate dataVidimazione) {
		this.dataVidimazione = dataVidimazione;
	}


	public boolean isVidimato() {
		return vidimato;
	}


	public void setVidimato(boolean vidimato) {
		this.vidimato = vidimato;
	}


	@Override
	public String toString() {
		return "Biglietto [vidimato=" + vidimato + ", mezzo=" + mezzo + ", dataVidimazione=" + dataVidimazione
				+ ", getId()=" + getId() + ", getDataDiEmissione()=" + getDataDiEmissione() + ", getLuogoEmissione()="
				+ getLuogoEmissione() + "]";
	}




	
	
	
	
	
	

}
