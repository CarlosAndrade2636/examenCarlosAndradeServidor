package ec.edu.ups.ExamenAndradeCarlosServidor.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.ExamenAndradeCarlosServidor.modelo.Producto;


@Stateless
public class ProductoDAO {
	
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;
	
	public boolean insert(Producto producto) throws SQLException {
		em.persist(producto);
		
		return true;
	}
	public boolean update(Producto producto) throws SQLException {
		em.merge(producto);
		return true;
	}
	public Producto read(int id){
		Producto producto=em.find(Producto.class, id);
		return producto;
	}
	public boolean delete(int id) throws SQLException {
		Producto producto= this.read(id);
		em.remove(producto);
		return true;

	}
	public List<Producto> getClientes(){
		String jpql="SELECT c FROM producto c WHERE id=?";
		
		Query q= em.createQuery(jpql, Producto.class);
		q.setParameter(1,1);

		List<Producto> resultList = (List<Producto>)q.getResultList();
		return resultList;
		
	}

}
