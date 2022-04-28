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
//
@Entity
@Table(name = "residente")
@Getter
@Setter
public class Residente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResidente;
	private String nombre;
	private String apellidos;
	private String dni;
	private String correo;
	private int idmascota;
	private String estado;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaReg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	private int telefono;
	private int activo;
	

}
