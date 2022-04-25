package com.departamento.entity;

import java.io.Serializable;
import java.util.Date;

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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table (name="visita")
@Getter
@Setter
@ToString 
public class visita implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idvisita ;
	
	@ManyToOne
	@JoinColumn(name = "idvisitante")
	private visitante idvisitante ; 
	
	private int idresidente ; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaentrada ; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date horasalida ;
	
	
}
