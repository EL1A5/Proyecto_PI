package com.departamento.entity;

import java.util.Date;

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
@Table(name = "insidencia")
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
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idResidente")
	private Residente residente; 
	
	
	@ManyToOne
	@JoinColumn(name = "iddepartamento")
	private Departamento departamento;
	
	private String tipo ; 
	private String descripcion ;
	private String estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechareg ;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaatencion ;
	
	
	
	
	
	

}
