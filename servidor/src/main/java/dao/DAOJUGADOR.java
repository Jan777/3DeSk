package dao;

import java.io.IOException;
import java.sql.SQLException;


public abstract class DAOJUGADOR {
	public abstract void insertar(String user,String pass, boolean activo) throws SQLException,IOException;
	public abstract void actualizar(String usuario, boolean activo) throws SQLException,IOException;
	public abstract boolean buscar(String user) throws SQLException;
	public abstract void borrar(String user) throws SQLException,IOException;
	public abstract String seleccionarUsuario(String usuario) throws SQLException,IOException;
	public abstract void listarDatos() throws SQLException,IOException;
	public abstract void cerrar() throws IOException;
}