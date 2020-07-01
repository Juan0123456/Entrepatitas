package edu.cibertec.persistence.jpa.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import edu.cibertec.entity.Cliente;



public class ClienteJPA extends GenericoJPA{

	
	private static final long serialVersionUID = 1L;

	public Cliente get(Integer id) throws Exception{
		return em.find(Cliente.class, id);
	}
	
	
	public List<Cliente> getAll() throws Exception {
		TypedQuery<Cliente> query = em.createQuery("FROM Cliente ORDER BY idCliente DESC",Cliente.class);
		return query.getResultList();
	}
	
	
	public List<Cliente> getAllxCliente(int id) throws Exception {
		TypedQuery<Cliente> query = em.createQuery("FROM Cliente where idCliente = ?1",Cliente.class);
		query.setParameter(1, id);
		return query.getResultList();
	}

	
	public void registrar(Cliente ClienteJPA) throws Exception{
		em.persist(ClienteJPA);
	}
	
	
	public void actualizar(Cliente ClienteJPA) throws Exception{
		em.merge(ClienteJPA);
	}

	
}
