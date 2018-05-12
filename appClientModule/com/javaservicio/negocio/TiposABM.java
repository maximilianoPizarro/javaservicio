package com.javaservicio.negocio;

import com.javaservicio.dao.TiposDao;
import com.javaservicio.modelo.Login;
import com.javaservicio.modelo.Tipos;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TiposABM {
	
	private TiposDao daoA=new TiposDao();
	
	public Tipos traerTipo(int idtipologin) throws Exception {

		Tipos a = daoA.traerTipo(idtipologin);

		if (a == null) {
			throw new Exception("No existe tipo con ese id");
		}
		return a;
	}
/*	
	public List traerTipos() throws Exception {

		List a = daoA.findAll();

		if (a == null) {
			throw new Exception("No existe Registro con ese dominio");
		}
		return a;
	}
*/
	
	}



	
