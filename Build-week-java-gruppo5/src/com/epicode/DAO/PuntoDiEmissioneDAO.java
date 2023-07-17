package com.epicode.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.epicode.model.PuntoDiEmissione;

public class PuntoDiEmissioneDAO {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Build-week-java-gruppo5").createEntityManager();
	static Logger log = LoggerFactory.getLogger(BigliettoDAO.class);
	
	
	public static void salvaPuntoEmissione(PuntoDiEmissione p) {
		try  {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		log.info("Punto di emissione salvato nel database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static void eliminaPuntoEmissione(PuntoDiEmissione p) {
		try  {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		log.info("Punto di emissione rimosso dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static PuntoDiEmissione getPuntoDiEmissioneById(Long id) {
		try {
		em.getTransaction().begin();
		PuntoDiEmissione p = em.find(PuntoDiEmissione.class, id);
		em.getTransaction().commit();
		return p;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}

}
