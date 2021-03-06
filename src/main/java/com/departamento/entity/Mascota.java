package com.departamento.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table (name="mascota")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Mascota implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMascota;
	@ManyToOne
	@JoinColumn(name="idResidente")
	private Residente residente;
	
	@NotEmpty
	@Pattern(regexp="[A-Za-z]+([ '-][a-zA-Z]+)*")
	private String nombre;
	private String edad;
	private String tipo;
	@Pattern(regexp="[A-Za-z]+([ '-][a-zA-Z]+)*")
	private String raza;
	private String vacunacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechareg;
	private int estado;
	
	
}











