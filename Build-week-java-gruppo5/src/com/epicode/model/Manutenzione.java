package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manutenzione")
public class Manutenzione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	@ManyToOne
	private Mezzo mezzo;
	
	
	public Manutenzione() {
		super();
	}


	public Manutenzione(LocalDate dataInizio, LocalDate dataFine, Mezzo mezzo) {
		super();
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.mezzo = mezzo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getDataInizio() {
		return dataInizio;
	}


	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}


	public LocalDate getDataFine() {
		return dataFine;
	}


	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}


	public Mezzo getMezzo() {
		return mezzo;
	}


	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}


	@Override
	public String toString() {
		return "Manutenzione [id=" + id + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", mezzo=" + mezzo
				+ "]";
	}
	
	

	
	
}
