package com.departamento.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "incidencia")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Insidencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idincidencia ;
	
	@ManyToOne
	@JoinColumn(name = "iduser")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idResidente")
	private Residente residente; 
	
	
	@ManyToOne
	@JoinColumn(name = "iddepartamento")
	private Departamento departamento;
	
	private String tipo ; 
	
	@Column(length = 1200)
	private String descripcion ;
	private int estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechareg ;
	
	
	
	
	
	
	

}
