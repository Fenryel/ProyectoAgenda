package com.ejemplos.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.dao.IContactoDAO;
import com.ejemplos.spring.model.Personas;

@Service
public class ContactoService implements IContactoService {
	
	@Autowired
	private IContactoDAO iContactoDao;
	
	public List<Personas> list() {
		return iContactoDao.list();
	}
	
	public Personas get(int id) {
		return iContactoDao.get(id);
	}
	
	public void modificar(Personas personas) {
		iContactoDao.modificarEmp(personas);
	}

	public void borrarContacto(int idPersona) {
		// TODO Auto-generated method stub
		
	}



}
