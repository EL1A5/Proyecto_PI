package com.departamento.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="visitante")
@Getter
@Setter
@ToString
public class visitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvisitante;
	
	private String nombre ;
	private String apellidos ;
	private int dni; 
	@DateTimeFormat(pattern = "yyyyMMddHHmmss")
	@Temporal(TemporalType.DATE)
	private Date  fechareg  ;
	private int activo;
	
}
