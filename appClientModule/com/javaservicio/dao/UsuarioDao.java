package com.javaservicio.dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaservicio.modelo.Login;
import com.javaservicio.modelo.Usuario;

public class UsuarioDao {
	
	
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
	
	public int agregar(Usuario objeto){
		int id=0;
		try{
			iniciaOperacion();
			id=Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch (HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return id;
	}
	
	
	
	public Usuario traerUsuario(int idusuario) throws HibernateException {
		Usuario objeto = null;
		try {
			iniciaOperacion();
			String hql="from Usuario innerjoin where idusuario =:idusuario";
			
			objeto=(Usuario) session.createQuery(hql).setParameter("idusuario", (int)idusuario).uniqueResult();
	
		}catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
				session.close();
				}
		return objeto;
		}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> traerUsuarios()
			throws HibernateException {
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Usuario";
			lista = session.createQuery(hql).list();

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return lista;
	}
	

}
