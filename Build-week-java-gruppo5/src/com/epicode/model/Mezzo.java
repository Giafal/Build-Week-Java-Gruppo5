package com.epicode.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "mezzo")
public class Mezzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany
	private List<Manutenzione> periodiManutenzione;
	
	public Mezzo() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Mezzo [id=" + id + ", periodiManutenzione=" + periodiManutenzione + "]";
	}

	
	
}
