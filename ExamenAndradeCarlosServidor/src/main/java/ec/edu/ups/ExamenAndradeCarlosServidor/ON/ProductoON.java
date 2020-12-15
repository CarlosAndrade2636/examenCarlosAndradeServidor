package ec.edu.ups.ExamenAndradeCarlosServidor.ON;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ExamenAndradeCarlosServidor.DAO.ProductoDAO;
import ec.edu.ups.ExamenAndradeCarlosServidor.modelo.Producto;



@Stateless
public class ProductoON implements ProdutoONREmoto {

	
	@Inject
	private ProductoDAO daoProducto;
	
	public boolean guardarProducto(Producto producto ) throws Exception {
		//Validaciones de cliente
		
		try {
			daoProducto.insert(producto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al registar producto ");
		}
		
		return true;
	}
	
	public boolean eliminarProducto(int id ) throws Exception {
	
		
		try {
			daoProducto.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al registar producto ");
		}
		
		return true;
	}
	
public Producto buscarrProducto(int id ) throws Exception {
	

		try {
			Producto producto = daoProducto.read(id);
			return producto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al registar producto ");
		}
		
		
	}
	

public List<Producto> getTickets(){
	try {
		List<Producto>producto=daoProducto.getClientes();
		return producto;
		
	}catch(Exception e) {
		e.printStackTrace();
		return new ArrayList<Producto>();
	}
}
	
public boolean actualizarProducto(Producto producto ) throws Exception {
	
		
		try {
			daoProducto.update(producto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al registar producto ");
		}
		
		return true;
	}
}
