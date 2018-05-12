package com.javaservicio.negocio;

import com.javaservicio.dao.UsuarioDao;
import com.javaservicio.modelo.Usuario;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioABM {
	
	private UsuarioDao daoA=new UsuarioDao();
	
	public Usuario traerUsuario(int idusuario) throws Exception {

		Usuario a = daoA.traerUsuario(idusuario);

		if (a == null) {
			throw new Exception("No existe usuario con ese id");
		}
		return a;
	}
	
	public List<Usuario> traerUsuarios() throws Exception {
		List<Usuario> a = daoA.traerUsuarios();
		
		if (a == null) {
			throw new Exception("Lista vacia");
		}
		return a;
	}
	
	}



	
