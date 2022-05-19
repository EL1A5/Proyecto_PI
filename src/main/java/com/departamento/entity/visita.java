package com.departamento.entity;

import java.io.Serializable;

import java.util.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table (name="visita")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class visita implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvisita ;
	
	@ManyToOne
	@JoinColumn(name = "idvisitante")
	private visitante idvisitante ; 
	@ManyToOne
	@JoinColumn(name = "idResidente")
	private Residente residente; 
	@ManyToOne
	@JoinColumn(name = "iddepartamento")
	private Departamento departamento;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaentrada ; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date horasalida ;
	
	private String observacion;
	
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	
	 
	 
}
