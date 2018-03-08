package com.uned.practicatw.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PAGOS")
public class Pagos implements Serializable {

	private static final long serialVersionUID = 584784130010465872L;
	
	@Id
    @GeneratedValue
	private Integer id;
	
	@ManyToMany(mappedBy = "pagos")
	private Set<Persona> personas = new HashSet<Persona>();

	public Pagos() {
		super();
	}

	public Pagos(Integer id) {
		super();
		this.id = id;
	}
	
	
	

}
