package com.uned.practicatw.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
	    @Column(name = "PERFIL_ID")
	    @GeneratedValue
	    private Integer perfil_id;

	    @Column(name = "nombre")
	    @Size(min = 1, max = 30)
	    @NotNull
	    private String nombre;
	    
	    @OneToMany(mappedBy="perfil")
	    private List<Persona> personas;
	    
	    public Perfil(Integer perfil_id, String nombre) {
			super();
			this.perfil_id = perfil_id;
			this.nombre = nombre;
		}

		public Integer getPerfil_id() {
			return perfil_id;
		}

		public void setPerfil_id(Integer perfil_id) {
			this.perfil_id = perfil_id;
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
