package com.ejemplos.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplos.spring.model.Personas;

@Repository
public class ContactoDAO implements IContactoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public ContactoDAO() {
		
	}
	
	public ContactoDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Personas> list() {
		@SuppressWarnings("unchecked")
		List<Personas> listaPersonas = (List<Personas>) sessionFactory.getCurrentSession()
				.createCriteria(Personas.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listaPersonas;
	}
	
	@Override
	@Transactional
	public Personas get(int id) {
		String hql = "from User where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Personas> listUser = (List<Personas>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}
	
	@Override
	@Transactional
	public void modificarEmp(Personas personas) {
		sessionFactory.getCurrentSession().saveOrUpdate(personas);;
	}

}
