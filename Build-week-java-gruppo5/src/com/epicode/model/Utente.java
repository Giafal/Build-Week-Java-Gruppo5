package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utente {
	
	private String nome;
	private String cognome;
	private Integer eta;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroTessera;
	private LocalDate dataEmissioneTessera;
	private LocalDate dataScadenzaTessera;
	
	
	
	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, Integer eta, LocalDate dataEmissioneTessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.dataEmissioneTessera = dataEmissioneTessera;
		this.dataScadenzaTessera = dataEmissioneTessera.plusDays(365);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public Long getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(Long numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public LocalDate getDataEmissioneTessera() {
		return dataEmissioneTessera;
	}

	public void setDataEmissioneTessera(LocalDate dataEmissioneTessera) {
		this.dataEmissioneTessera = dataEmissioneTessera;
	}

	public LocalDate getDataScadenzaTessera() {
		return dataScadenzaTessera;
	}

	public void setDataScadenzaTessera(LocalDate dataScadenzaTessera) {
		this.dataScadenzaTessera = dataScadenzaTessera;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", numeroTessera=" + numeroTessera
				+ ", dataEmissioneTessera=" + dataEmissioneTessera + ", dataScadenzaTessera=" + dataScadenzaTessera
				+ "]";
	}
	
	
	

}
