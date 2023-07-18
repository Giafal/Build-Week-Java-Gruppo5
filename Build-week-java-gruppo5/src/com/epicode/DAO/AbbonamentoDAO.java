package com.epicode.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Abbonamento;
import com.epicode.model.Utente;

public class AbbonamentoDAO {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Build-week-java-gruppo5").createEntityManager();
	static Logger log = LoggerFactory.getLogger(AbbonamentoDAO.class);
	
	
	public static void salvaAbbonamento(Abbonamento a) {
		try  {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		log.info("Abbonamento salvato nel database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
			throw e;
		} finally {
			em.close();
		}
	}
	
	public static void eliminaAbbonamento(Abbonamento a) {
		try  {
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
		log.info("Abbonamento rimosso dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static Abbonamento getAbbonamentoById(Long id) {
		try {
		em.getTransaction().begin();
		Abbonamento a = em.find(Abbonamento.class, id);
		em.getTransaction().commit();
		return a;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}


}
