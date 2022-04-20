package com.departamento.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
*/
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="Mascota")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmascota;
	private int idresidente;
	private String nombre;
	private String tipo;
	private String fechareg;
	private int activo;
	
	/*
	@OneToMany
	@JoinColumn(name = "idresidente")
	private Residente residente;
	*/
}









