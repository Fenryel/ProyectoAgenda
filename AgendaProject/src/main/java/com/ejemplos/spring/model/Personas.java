package com.ejemplos.spring.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Personas generated by hbm2java
 */
@Entity
@Table(name = "personas", catalog = "agenda")
public class Personas implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Empleados empleados;
	private Integer idpersonas;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private Date fechaNacimiento;
	private Set<Direcciones> direccioneses = new HashSet<Direcciones>(0);
	private Set<Telefonos> telefonoses = new HashSet<Telefonos>(0);
	

	public Personas() {
	}

	public Personas(String nombre, String apellido1) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
	}
	
	public Personas(String nombre, String apellido1, String apellido2, String dni, Date fechaNacimiento) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Personas(Empleados empleados, String nombre, String apellido1, String apellido2, String dni,
			Date fechaNacimiento, Set<Direcciones> direccioneses, Set<Telefonos> telefonoses) {
		this.empleados = empleados;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.direccioneses = direccioneses;
		this.telefonoses = telefonoses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idpersonas", unique = true, nullable = false)
	public Integer getIdpersonas() {
		return this.idpersonas;
	}

	public void setIdpersonas(Integer idpersonas) {
		this.idpersonas = idpersonas;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade =CascadeType.REMOVE)
	@JoinColumn(name = "idEmpleado")
	public Empleados getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Empleados empleados) {
		this.empleados = empleados;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido1", nullable = false, length = 45)
	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "apellido2", length = 45)
	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column(name = "dni", length = 20)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaNacimiento", length = 10)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personas", cascade =CascadeType.REMOVE)
	public Set<Direcciones> getDireccioneses() {
		return this.direccioneses;
	}

	public void setDireccioneses(Set<Direcciones> direccioneses) {
		this.direccioneses = direccioneses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personas", cascade =CascadeType.REMOVE)
	public Set<Telefonos> getTelefonoses() {
		return this.telefonoses;
	}

	public void setTelefonoses(Set<Telefonos> telefonoses) {
		this.telefonoses = telefonoses;
	}

}
