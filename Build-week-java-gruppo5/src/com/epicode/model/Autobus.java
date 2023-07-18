package com.epicode.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Autobus extends Mezzo {
	
	private Integer capienza;

	public Autobus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Autobus(List<Manutenzione> periodiManutenzione, Integer capienza) {
		super(periodiManutenzione);
		this.capienza = 50;
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
		return "Autobus [capienza=" + capienza + ", getId()=" + getId() + ", getPeriodiManutenzione()="
				+ getPeriodiManutenzione() + "]";
	}

	
	
}
