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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "departamento")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddepartamento;
	
	@ManyToOne
	@JoinColumn(name="idpropietario")
	private Propietario propietario;
	private String numdepartamento;
	private int habitaciones;
	private double area;
	private int banos;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechareg;
	private String estado;
	
	
	
	
	
	

}
