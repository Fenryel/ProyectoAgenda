package com.ejemplos.spring.dao;

import java.util.List;

import com.ejemplos.spring.model.Personas;

public interface IContactoDAO {
	
	public List<Personas> list();
	
	public Personas get(int id);
	
	public void modificarEmp(Personas personas);
	
	

	public void borrarContacto(int idPersona);

}
