package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Tematica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="Nombre")
	private String nombre;
	@ManyToMany(mappedBy = "tematicas")
    @JsonIgnoreProperties("tematicas")
	private List<Chollo> chollos;
	public Tematica() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Chollo> getChollos() {
		return chollos;
	}
	public void setChollos(List<Chollo> chollos) {
		this.chollos = chollos;
	}
	
}