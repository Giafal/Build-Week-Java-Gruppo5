package com.epicode.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Manutenzione;
import com.epicode.model.Tram;


public class ManutenzioneDAO {

	static EntityManager em = Persistence.createEntityManagerFactory("Build-week-java-gruppo5").createEntityManager();
	static Logger log = LoggerFactory.getLogger(ManutenzioneDAO.class);

	public static void salvaManutenzione(Manutenzione m) {
		try  {
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		log.info("Manutenzione salvata nel database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
			throw e;
		} finally {
			em.close();
		}
	}
	
	public static void eliminaManutenzione(Manutenzione m) {
		try  {
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		log.info("Manutenzione rimossa dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static Manutenzione getManutenzioneById(Long id) {
		try {
		em.getTransaction().begin();
		Manutenzione m = em.find(Manutenzione.class, id);
		em.getTransaction().commit();
		return m;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static void modificaManutenzione(Manutenzione m) {
		try  {
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		log.info("Manutenzione modificata.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
}
