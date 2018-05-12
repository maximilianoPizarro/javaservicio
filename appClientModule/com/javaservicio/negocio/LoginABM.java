package com.javaservicio.negocio;

import com.javaservicio.dao.LoginDao;
import com.javaservicio.modelo.Login;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginABM {
	
	private LoginDao daoA=new LoginDao();
	
	public Login traerLogin(int idLogin) throws Exception {

		Login a = daoA.traerLogin(idLogin);

		if (a == null) {
			throw new Exception("No existe Registro con ese dominio");
		}
		return a;
	}

	
	}



	
