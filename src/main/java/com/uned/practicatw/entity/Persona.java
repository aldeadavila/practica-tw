package com.uned.practicatw.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERSONAS")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;
    

    @ManyToOne
    @JoinColumn(name = "perfil")
    private Perfil perfil;

    @Size(min = 1, max = 30)
    @NotNull
    private String nombre;

    @Min(1)
    @Max(200)
    @NotNull
    private Integer edad;
    
    @ManyToMany(cascade = { 
    	    CascadeType.PERSIST, 
    	    CascadeType.MERGE
    	})
    	@JoinTable(name = "personas_pagos",
    	    joinColumns = @JoinColumn(name = "persona_id"),
    	    inverseJoinColumns = @JoinColumn(name = "pagos_id")
    	)
    	private Set<Pagos> pagos = new HashSet<Pagos>();
    
    public Persona() {
		super();
	}

	public Persona(Perfil perfil, String nombre, Integer edad) {
		super();
		this.perfil = perfil;
		this.nombre = nombre;
		this.edad = edad;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", perfil=" + perfil + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

    
}
