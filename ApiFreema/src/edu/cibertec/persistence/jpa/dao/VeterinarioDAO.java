package edu.cibertec.persistence.jpa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.cibertec.entity.Veterinario;
import edu.cibertec.persistence.service.IVeterinarioService;

public class VeterinarioDAO implements IVeterinarioService{

	@Override
	public Veterinario getVeterinario(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veterinario> getVeterinarios() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veterinario getVeterinarioPorCodigo(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veterinario> getVeterinarioPorDistrito(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veterinario registrar(Veterinario Veterinario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veterinario actualizar(Veterinario Veterinario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veterinario login(String correo, String contrasena) {
		Veterinario vetDTO=null;
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
		   con = edu.cibertec.util.MySQLConexion.getConexion();
		   String sql = "select * from tb_veterinario where correo=? and contrasena=?";
		   pst = con.prepareStatement(sql);   // prepara la sentencia
		   pst.setString(1, correo);
		   pst.setString(2, contrasena);
		   
		   rs = pst.executeQuery();
		   while (rs.next()){
			   vetDTO= new Veterinario();
			   vetDTO.setIdVet(rs.getInt(1));
			   vetDTO.setNombreVet(rs.getString(2));
			   vetDTO.setApePatVet(rs.getString(3));
			   vetDTO.setApeMatVet(rs.getString(4));
			   vetDTO.setRuc(rs.getString(5));
			   vetDTO.setDni(rs.getInt(6));
			   vetDTO.setTelefono(rs.getInt(6));
			   vetDTO.setCorreo(rs.getString(7));
			   vetDTO.setDireccion(rs.getString(8));
			   vetDTO.setNombreimg(rs.getString(9));
			   vetDTO.setContrasena(rs.getString(11));
			   
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia login usuario " + e.getMessage());
		} finally {
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar login usuario " + e.getMessage());
			}
		}
		return vetDTO;
	}

}
