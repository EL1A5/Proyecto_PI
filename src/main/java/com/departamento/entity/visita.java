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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table (name="visita")
@Getter
@Setter
@ToString 
public class visita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvisita ;
	
	@ManyToOne
	@JoinColumn(name = "idvisitante")
	private visitante idvisitante ; 
	
	private int idresidente ; 
	
	@DateTimeFormat(pattern = "yyyyMMddHHmmss")
	@Temporal(TemporalType.DATE)
	private Date horaentrada ; 
	
	@DateTimeFormat(pattern = "yyyyMMddHHmmss")
	@Temporal(TemporalType.DATE)
	private Date horasalida ;
}
