package edu.cibertec.persistence.jpa.dao;


import java.util.List;
import javax.persistence.TypedQuery;
import edu.cibertec.entity.Trabajador;

public class TrabajadorJPA extends GenericoJPA{
	
	

	private static final long serialVersionUID = 1L;

	public Trabajador get(Integer id) throws Exception{
		return em.find(Trabajador.class, id);
	}
	
	
	public List<Trabajador> getAll() throws Exception {
		TypedQuery<Trabajador> query = em.createQuery("FROM Trabajador ORDER BY idTrab DESC",Trabajador.class);
		return query.getResultList();
	}
	
	public List<Trabajador> getAllxTrabajador(int id) throws Exception {
		TypedQuery<Trabajador> query = em.createQuery("FROM Trabajador where idTrab = ?1",Trabajador.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	
	public List<Trabajador> TrabajadoresPorCarrera(int id) throws Exception {
		TypedQuery<Trabajador> query = em.createQuery("FROM Trabajador where idTecnico = ?1",Trabajador.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	
	public void registrar(Trabajador TrabajadorJPA) throws Exception{
		em.persist(TrabajadorJPA);
	}
	
	
	public void actualizar(Trabajador TrabajadorJPA) throws Exception{
		em.merge(TrabajadorJPA);
	}


}
