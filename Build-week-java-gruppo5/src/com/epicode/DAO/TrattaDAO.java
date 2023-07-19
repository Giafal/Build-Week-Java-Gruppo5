package com.epicode.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Tratta;

public class TrattaDAO {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Build-week-java-gruppo5").createEntityManager();
	static Logger log = LoggerFactory.getLogger(TrattaDAO.class);
	
	
	public static void salvaTratta(Tratta t) {
		try  {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		log.info("Tratttta salvato nel database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
			throw e;
		} finally {
			em.close();
		}
	}
	
	public static void eliminaTratta(Tratta t) {
		try  {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
		log.info("Tratta rimossa dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static Tratta getTrattaById(Long id) {
		try {
		em.getTransaction().begin();
		Tratta t = em.find(Tratta.class, id);
		em.getTransaction().commit();
		return t;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static void modificaTratta(Tratta t) {
		try  {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		log.info("Tratta modificata.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}

}
