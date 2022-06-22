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

import javax.persistence.ManyToOne;

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
@Table(name = "boleta")

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Boleta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idboleta ;
	
	@ManyToOne
	@JoinColumn(name = "idPropietario")
	private visitante idPropietario ; 
	
	private String mes;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechapago ;
	

	private String servicio;
	

	

 
}

public class Boleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idboleta;

	@ManyToOne
	@JoinColumn(name = "idservicio")
	private Servicio servicio;

	@ManyToOne
	@JoinColumn(name = "idpropietario")
	private Propietario propietario;

	
	private String anio;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private String fechaVenc;
	private String estado;

}
