package edu.cibertec.persistence.jpa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.entity.Cliente;
import edu.cibertec.persistence.service.IClienteService;

public class ClienteDAO implements IClienteService{

	@Override
	public Cliente getCliente(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> getClientes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getClientesPorCodigo(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente registrar(Cliente Cliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente actualizar(Cliente Cliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClienteDTO> getClientesPorCodigoVet(int id) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<ClienteDTO> lstClientexVet= new ArrayList<ClienteDTO>();
		try {
			con = edu.cibertec.util.MySQLConexion.getConexion();
			String sql = "{call sp_listado_solicitudCliente(?)}";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				
				ClienteDTO c = new ClienteDTO();
				c.setIdCliente(rs.getInt(1));
				c.setNombreCli(rs.getString(2));
				c.setApePatCli(rs.getString(3));
				c.setApeMatCli(rs.getString(4));
				c.setDireccionCli(rs.getString(5));
				c.setFecNacCli(rs.getString(6));
				c.setCorreoCli(rs.getString(7));
				c.setDniCli(rs.getInt(8));
				c.setNombreFotoCli(rs.getString(9));
				
				c.setContrasena(rs.getString(11));
				c.setIdVet(rs.getInt(12));
				
				lstClientexVet.add(c);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia getClientesPorCodigoVet: " + e.getMessage());
		} finally {
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar");
			}
		}

		return lstClientexVet;
	}

}
