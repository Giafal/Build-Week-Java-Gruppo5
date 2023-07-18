package com.epicode.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.DAO.AbbonamentoDAO;
import com.epicode.DAO.AutobusDAO;
import com.epicode.DAO.BigliettoDAO;
import com.epicode.DAO.ManutenzioneDAO;
import com.epicode.DAO.PuntoDiEmissioneDAO;
import com.epicode.DAO.TramDAO;
import com.epicode.DAO.UtenteDAO;
import com.epicode.enumaration.Stato;
import com.epicode.enumaration.Validita;
import com.epicode.model.Abbonamento;
import com.epicode.model.Autobus;
import com.epicode.model.Biglietto;
import com.epicode.model.DistributoreAutomatico;
import com.epicode.model.Manutenzione;
import com.epicode.model.Mezzo;
import com.epicode.model.PuntoDiEmissione;
import com.epicode.model.RivenditoreAutorizzato;
import com.epicode.model.Ticket;
import com.epicode.model.Tram;
import com.epicode.model.Utente;
import com.epicode.utils.JpaUtil;

public class Main {
	
	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();
	static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
//		DistributoreAutomatico da1 = new DistributoreAutomatico(Stato.ATTIVO, 5, 5);
//		RivenditoreAutorizzato ra1 = new RivenditoreAutorizzato(5, 5);
//////	
//		PuntoDiEmissione pde =PuntoDiEmissioneDAO.getPuntoDiEmissioneById(1l);
//		PuntoDiEmissione pde1 =PuntoDiEmissioneDAO.getPuntoDiEmissioneById(2l);
//		Utente u = UtenteDAO.getUtenteById(1l);
//////		
//////		
//		Biglietto b1 = new Biglietto(LocalDate.of(2023, 7, 17), pde, true);
//		Utente u1 = new Utente("Gianluca", "Falcone", 36, LocalDate.of(2023, 7, 17));
//		Abbonamento a1 = new Abbonamento(LocalDate.of(2023, 7, 17), pde1, Validita.MENSILE, u);
		
		//PuntoDiEmissioneDAO.salvaPuntoEmissione(ra1);
		//BigliettoDAO.salvaBiglietto(b1);
		//Biglietto b = BigliettoDAO.getBigliettoById(7l);
		//System.out.println(b);
		//BigliettoDAO.eliminaBiglietto(b);
		//UtenteDAO.salvaUtente(u1);
		//AbbonamentoDAO.salvaAbbonamento(a1);
		//Abbonamento a = AbbonamentoDAO.getAbbonamentoById(2l);
//		AbbonamentoDAO.eliminaAbbonamento(a);
		
//		List<Ticket> listaBiglietti = ricercaBiglietti(LocalDate.of(2023, 5, 5), LocalDate.of(2023, 8, 8));
//		listaBiglietti.forEach(e -> System.out.println(e));
		
//		List<Ticket> listaBiglietti2 = ricercaPerPuntoEmissione(pde1);
//		listaBiglietti2.forEach(e -> System.out.println(e));
		
		//verificaValiditaMensile(a, 1l);
		
		//crea mezzi
		Tram t1 = new Tram(null, 100);
		Autobus au1 = new Autobus(null, 50);
		Tram t2 = new Tram(null, 170);
		
	//Salva mezzi
		//TramDAO.salvaTram(t2);
		//AutobusDAO.salvaAutobus(au1);
		
	//Get Mezzi by id
		//Autobus Cax = AutobusDAO.getAutobusById(2l);
		//Tram Vel = TramDAO.getTramById(5l);
		
		
	//Crea manutenzione
		//Manutenzione m1 = new Manutenzione(LocalDate.of(2023, 10, 20),LocalDate.of(2024, 5, 17), Cax);
		//Manutenzione m2 = new Manutenzione(LocalDate.of(2022, 9, 20),LocalDate.of(2023, 1, 13), Vel);
		
		//List<Manutenzione> lista1 = new ArrayList<Manutenzione>();
		//List<Manutenzione> lista2 = new ArrayList<Manutenzione>();
		
		//lista1.add(m1);
		//lista2.add(m2);
		
		
	//verifica manutenzione
		//au1.setPeriodiManutenzione(lista1);
		//t1.setPeriodiManutenzione(lista2);
		//Vel.setPeriodiManutenzione(lista2);
		
		//ManutenzioneDAO.salvaManutenzione(m1);
		//ManutenzioneDAO.salvaManutenzione(m2);
		
		
	//modifica mezzo
		//AutobusDAO.modificaAutobus(Cax);
		//TramDAO.modificaTram(Vel);
		
	//lancio metodo verificaStatusMezzo
		List<Manutenzione> manutenzione1 = verificaStatusMezzo();
		//log.info(manutenzione1 + "");
		for(Manutenzione m : manutenzione1) {
			log.info(m.toString());//problema stampare @override toString da errore!!
		}
	}
	
	//Test ricerca ticket totali in un dato periodo
	public static List<Ticket> ricercaBiglietti(LocalDate s, LocalDate e) {
		Query q = em.createNamedQuery("ticketTotali");
		q.setParameter("startDate", s);
		q.setParameter("endDate", e);
		return q.getResultList();
		
	}
	
	//test ricerca ticket totali per punto di emissione
	public static List<Ticket> ricercaPerPuntoEmissione(PuntoDiEmissione pDE){
		Query q = em.createNamedQuery("ticketPerPuntoEmissione");
		q.setParameter("pDE", pDE);
		return q.getResultList();
	}

	//Test verifica validità dell'abbonamento tramite numero tessera dell'utente
	
	public static void verificaValiditaMensile(Abbonamento a, Long id) {
		if (LocalDate.now().isAfter(a.getDataDiEmissione())  && LocalDate.now().isBefore(a.getDataDiEmissione().plusDays(30))   && a.getTitolare().getNumeroTessera() == id) {
			log.info("L'abbonamento è valido!!!");
		} else {
			log.error("L'abbonamento è scaduto!!!");
		}
	}
	
	public static void verificaValiditaSettimanale(Abbonamento a, Long id) {
		if (LocalDate.now().isAfter(a.getDataDiEmissione())  && LocalDate.now().isBefore(a.getDataDiEmissione().plusDays(7))   && a.getTitolare().getNumeroTessera() == id) {
			log.info("L'abbonamento è valido!!!");
		} else {
			log.error("L'abbonamento è scaduto!!!");
		}
	}
	
	public static List<Manutenzione> verificaStatusMezzo() {
		Query q = em.createQuery("SELECT m FROM Manutenzione m");
		return q.getResultList();
	}
	
}
