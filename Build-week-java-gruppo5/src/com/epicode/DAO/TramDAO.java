package com.epicode.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Tram;

public class TramDAO {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Build-week-java-gruppo5").createEntityManager();
	static Logger log = LoggerFactory.getLogger(BigliettoDAO.class);
	
	
	public static void salvaTram(Tram t) {
		try  {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		log.info("Tram salvato nel database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
			throw e;
		} finally {
			em.close();
		}
	}
	
	public static void eliminaTram(Tram t) {
		try  {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
		log.info("Tram rimosso dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static Tram getTramById(Long id) {
		try {
		em.getTransaction().begin();
		Tram t = em.find(Tram.class, id);
		em.getTransaction().commit();
		return t;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static void modificaTram(Tram t) {
		try  {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		log.info("Tram modificato.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}

}
