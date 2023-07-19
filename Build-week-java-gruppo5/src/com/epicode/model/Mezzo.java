package com.epicode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "mezzo")

public class Mezzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade = CascadeType.ALL )
	@Column
	private List<Manutenzione> periodiManutenzione;
	@OneToMany(cascade = CascadeType.ALL )
	@Column
	private List<Tratta> tratte;
	
	public Mezzo() {
		super();
	}

	public Mezzo(List<Manutenzione> periodiManutenzione) {
		super();
		this.periodiManutenzione = periodiManutenzione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Manutenzione> getPeriodiManutenzione() {
		return periodiManutenzione;
	}

	public void setPeriodiManutenzione(List<Manutenzione> periodiManutenzione) {
		this.periodiManutenzione = periodiManutenzione;
	}

	public List<Tratta> getTratte() {
		return tratte;
	}

	public void setTratte(List<Tratta> tratte) {
		this.tratte = tratte;
	}

	@Override
	public String toString() {
		return "Mezzo [id=" + id + ", periodiManutenzione=" + periodiManutenzione + ", tratte=" + tratte + "]";
	}

	

	
	
}
