package com.uned.practicatw.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERFILES")
public class Perfil implements Serializable{

	private static final long serialVersionUID = 771502648623102367L;
	
	 	@Id
	    @GeneratedValue
	    private Integer id;

	    @Size(min = 1, max = 30)
	    @NotNull
	    private String nombre;
	    
	    @OneToMany(
	            mappedBy = "perfil", 
	            cascade = CascadeType.ALL, 
	            orphanRemoval = true
	        )
	    private List<Persona> personas = new ArrayList<Persona>();
	    
	    public Perfil() {
	    	super();
	    }
	    
	    public Perfil(Integer perfil_id, String nombre) {
			super();
			this.id = perfil_id;
			this.nombre = nombre;
		}

		public Integer getPerfil_id() {
			return id;
		}

		public void setPerfil_id(Integer perfil_id) {
			this.id = perfil_id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public List<Persona> getPersonas() {
			return personas;
		}

		public void setPersonas(List<Persona> personas) {
			this.personas = personas;
		}
	    

}
