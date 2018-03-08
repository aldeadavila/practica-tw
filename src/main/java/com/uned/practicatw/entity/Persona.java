package com.uned.practicatw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @Column(name = "PERSONA_ID")
    @GeneratedValue
    private Integer persona_id;
    
    @Column(name = "PERFIL")
    @GeneratedValue
    private Integer perfil;

    @Column(name = "NOMBRE")
    @Size(min = 1, max = 30)
    @NotNull
    private String nombre;

    @Column(name = "EDAD")
    @Min(1)
    @Max(200)
    @NotNull
    private Integer edad;

    public Integer getId() {
        return persona_id;
    }

    public void setId(Integer id) {
        this.persona_id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public Integer getAge() {
        return edad;
    }

    public void setAge(Integer age) {
        this.edad = age;
    }

    @Override
    public String toString() {
        return "Person [id=" + persona_id + ", nombre=" + nombre + ", edad=" + edad + "]";
    }
}
