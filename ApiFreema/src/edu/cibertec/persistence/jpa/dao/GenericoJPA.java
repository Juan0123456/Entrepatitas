package edu.cibertec.persistence.jpa.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import edu.cibertec.util.JPAUtil;

public abstract class GenericoJPA implements Serializable{
	private static final long serialVersionUID = 1L;
	protected EntityManager em;
	static final Logger log = Logger.getLogger(GenericoJPA.class);
	public void createEM() {
		log.info("Se captura el entityManager");
		em = JPAUtil.getEmf().createEntityManager();
	}
	public void releaseEM() {
		em.close();
	}

	public void beginTransaction() {
		
		log.info("em.getTransaction().begin();");
		em.getTransaction().begin();
	}

	public void endTransaction() {
		em.getTransaction().commit();
		releaseEM();
	}
	
	public void rollbackTransaction() {
		em.getTransaction().rollback();
		releaseEM();
	}
	
	public void flush() {
		em.flush();
	}
	
	public void setEM(EntityManager em){
		this.em=em;
	}
	public EntityManager getEM(){
		return em;
	}
}
