package com.epicode.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Tram extends Mezzo {
	
	private Integer capienza;

	public Tram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tram(List<Manutenzione> periodiManutenzione, Integer capienza) {
		super(periodiManutenzione);
		this.capienza = 100;
		// TODO Auto-generated constructor stub
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	@Override
	public String toString() {
		return "Tram [capienza=" + capienza + ", getId()=" + getId() + ", getPeriodiManutenzione()="
				+ getPeriodiManutenzione() + "]";
	}
	
	
	

}
