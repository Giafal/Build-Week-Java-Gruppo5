package com.epicode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "trovaTratte", query = "SELECT tr FROM Tratta tr WHERE tr.mezzo.id = :id")
@NamedQuery(name = "travaTempoEffettivo", query = "SELECT tr FROM Tratta tr")
public class Tratta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String partenza;
	private String capolinea;
	private Integer tempoMedio;
	private Integer tempoEffettivo;
	@ManyToOne
	private Mezzo mezzo;
	
	public Tratta(String partenza, String capolinea, Integer tempoMedio, Integer tempoEffettivo, Mezzo mezzo) {
		super();
		this.partenza = partenza;
		this.capolinea = capolinea;
		this.tempoMedio = tempoMedio;
		this.tempoEffettivo = tempoEffettivo;
		this.mezzo = mezzo;
	}


	public Tratta() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPartenza() {
		return partenza;
	}


	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}


	public String getCapolinea() {
		return capolinea;
	}


	public void setCapolinea(String capolinea) {
		this.capolinea = capolinea;
	}


	public Integer getTempoMedio() {
		return tempoMedio;
	}


	public void setTempoMedio(Integer tempoMedio) {
		this.tempoMedio = tempoMedio;
	}


	public Integer getTempoEffettivo() {
		return tempoEffettivo;
	}


	public void setTempoEffettivo(Integer tempoEffettivo) {
		this.tempoEffettivo = tempoEffettivo;
	}


	@Override
	public String toString() {
		return "Tratta [id=" + id + ", partenza=" + partenza + ", capolinea=" + capolinea + ", tempoMedio=" + tempoMedio
				+ ", tempoEffettivo=" + tempoEffettivo + "]";
	}
	
	
}
