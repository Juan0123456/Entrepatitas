package edu.cibertec.persistence.jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import edu.cibertec.entity.Contrato;
import edu.cibertec.entity.Distrito;
import edu.cibertec.entity.Servicio;
import edu.cibertec.entity.Solicitud;

public class ServicioJPA extends GenericoJPA{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Servicio get(Integer id) throws Exception{
		return em.find(Servicio.class, id);
	}
	
	
	public List<Servicio> getAll(int id) throws Exception {
		TypedQuery<Servicio> query = em.createQuery("FROM Proyecto where idVet = ?1",Servicio.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	public void registrar(Servicio ServicioJPA) throws Exception{
		em.persist(ServicioJPA);
	}
	
	public List<Servicio> getServiciosXVeterinario(int id) throws Exception {
		TypedQuery<Servicio> query = em.createQuery("FROM Servicio where idVet = ?1",Servicio.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	public void actualizar(Servicio ServicioJPA) throws Exception{
		em.merge(ServicioJPA);
	}
	
	
	public void eliminar(Servicio ServicioJPA) throws Exception{
		em.remove(ServicioJPA);
	}
	
}
