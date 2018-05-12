package com.javaservicio.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaservicio.modelo.Tipos;

public class TiposDao {
	
	
	private static Session session;

	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public Tipos traerTipo(int idtipologin) throws HibernateException {
		Tipos objeto = null;
		try {
			iniciaOperacion();
			String hql="from Tipos where idtipologin =:idtipologin";			
			objeto=(Tipos) session.createQuery(hql).setParameter("idtipologin", (int)idtipologin).uniqueResult();
	
		}catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
				session.close();
				}
		return objeto;
		}
	
    


}
