package com.epicode.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Autobus;


public class AutobusDAO {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Build-week-java-gruppo5").createEntityManager();
	static Logger log = LoggerFactory.getLogger(BigliettoDAO.class);
	
	
	public static void salvaAutobus(Autobus a) {
		try  {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		log.info("Autobus salvato nel database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
			throw e;
		} finally {
			em.close();
		}
	}
	
	public static void eliminaAutobus(Autobus a) {
		try  {
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
		log.info("Autobus rimosso dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static Autobus getTramById(Long id) {
		try {
		em.getTransaction().begin();
		Autobus t = em.find(Autobus.class, id);
		em.getTransaction().commit();
		return t;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static void modificaTram(Autobus a) {
		try  {
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		log.info("Autobus modificato.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}


}
