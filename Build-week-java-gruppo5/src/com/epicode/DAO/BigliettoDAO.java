package com.epicode.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Autobus;
import com.epicode.model.Biglietto;

public class BigliettoDAO {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Build-week-java-gruppo5").createEntityManager();
	static Logger log = LoggerFactory.getLogger(BigliettoDAO.class);
	
	
	public static void salvaBiglietto(Biglietto b) {
		try  {
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		log.info("Biglietto salvato nel database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
			throw e;
		} finally {
			em.close();
		}
	}
	
	public static void eliminaBiglietto(Biglietto b) {
		try  {
		em.getTransaction().begin();
		em.remove(b);
		em.getTransaction().commit();
		log.info("Biglietto rimosso dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static Biglietto getBigliettoById(Long codiceBiglietto) {
		try {
		em.getTransaction().begin();
		Biglietto b = em.find(Biglietto.class, codiceBiglietto);
		em.getTransaction().commit();
		return b;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static void modificaBiglietto(Biglietto b) {
		try  {
		em.getTransaction().begin();
		em.merge(b);
		em.getTransaction().commit();
		log.info("Biglietto modificato.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}

}
