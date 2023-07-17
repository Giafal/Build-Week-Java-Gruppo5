package com.epicode.controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.epicode.DAO.AbbonamentoDAO;
import com.epicode.DAO.BigliettoDAO;
import com.epicode.DAO.PuntoDiEmissioneDAO;
import com.epicode.DAO.UtenteDAO;
import com.epicode.enumaration.Stato;
import com.epicode.enumaration.Validita;
import com.epicode.model.Abbonamento;
import com.epicode.model.Biglietto;
import com.epicode.model.DistributoreAutomatico;
import com.epicode.model.PuntoDiEmissione;
import com.epicode.model.RivenditoreAutorizzato;
import com.epicode.model.Ticket;
import com.epicode.model.Utente;
import com.epicode.utils.JpaUtil;

public class Main {
	
	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		DistributoreAutomatico da1 = new DistributoreAutomatico(Stato.ATTIVO, 5, 5);
		RivenditoreAutorizzato ra1 = new RivenditoreAutorizzato(5, 5);
//	
		PuntoDiEmissione pde =PuntoDiEmissioneDAO.getPuntoDiEmissioneById(1l);
		PuntoDiEmissione pde1 =PuntoDiEmissioneDAO.getPuntoDiEmissioneById(2l);
		Utente u = UtenteDAO.getUtenteById(1l);
//		
//		
		Biglietto b1 = new Biglietto(LocalDate.of(2023, 7, 17), true, pde);
		Utente u1 = new Utente("Gianluca", "Falcone", 36, LocalDate.of(2023, 7, 17));
		Abbonamento a1 = new Abbonamento(LocalDate.of(2023, 7, 17), Validita.MENSILE, u, pde1);
		
		//PuntoDiEmissioneDAO.salvaPuntoEmissione(ra1);
		//BigliettoDAO.salvaBiglietto(b1);
		//Biglietto b = BigliettoDAO.getBigliettoById(7l);
		//System.out.println(b);
		//BigliettoDAO.eliminaBiglietto(b);
		//UtenteDAO.salvaUtente(u1);
		//AbbonamentoDAO.salvaAbbonamento(a1);
//		Abbonamento a = AbbonamentoDAO.getAbbonamentoById(3l);
//		AbbonamentoDAO.eliminaAbbonamento(a);
		
//		List<Ticket> listaBiglietti = ricercaBiglietti(LocalDate.of(2023, 5, 5), LocalDate.of(2023, 8, 8));
//		listaBiglietti.forEach(e -> System.out.println(e));
		

	}
	
	public static List<Ticket> ricercaBiglietti(LocalDate s, LocalDate e) {
		Query q = em.createNamedQuery("ticketTotali");
		q.setParameter("startDate", s);
		q.setParameter("endDate", e);
		return q.getResultList();
		
	}

}
