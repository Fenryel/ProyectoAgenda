package com.ejemplos.spring.services;

import java.util.List;

import com.ejemplos.spring.model.Personas;

public interface IContactoService {
	
	public List<Personas> list();
	
	public Personas get(int id);
	
	public void modificar(Personas personas);
	
	public void borrarContacto(int idPersona);

}
