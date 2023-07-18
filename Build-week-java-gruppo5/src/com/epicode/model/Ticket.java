package com.epicode.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "ticketTotali", query = "SELECT t FROM Ticket t  WHERE t.dataDiEmissione > :startDate AND t.dataDiEmissione < :endDate")
@NamedQuery(name = "ticketPerPuntoEmissione", query = "SELECT t FROM Ticket t WHERE t.luogoEmissione = :pDE")

public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataDiEmissione;
	@OneToOne
	private PuntoDiEmissione luogoEmissione;
	
	

	public Ticket() {
		super();
	}



	public Ticket(LocalDate dataDiEmissione, PuntoDiEmissione luogoEmissione) {
		super();
		this.dataDiEmissione = dataDiEmissione;
		this.luogoEmissione = luogoEmissione;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDate getDataDiEmissione() {
		return dataDiEmissione;
	}



	public void setDataDiEmissione(LocalDate dataDiEmissione) {
		this.dataDiEmissione = dataDiEmissione;
	}



	public PuntoDiEmissione getLuogoEmissione() {
		return luogoEmissione;
	}



	public void setLuogoEmissione(PuntoDiEmissione luogoEmissione) {
		this.luogoEmissione = luogoEmissione;
	}
	

	
	

}
