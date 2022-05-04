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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "residente")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Residente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResidente;
	
	@ManyToOne
	@JoinColumn(name="iddepartamento")
	private Departamento departamento;
	@NotEmpty
	@Pattern(regexp="[A-Za-z]+([ '-][a-zA-Z]+)*")
	private String nombre;
	@NotEmpty
	@Pattern(regexp="[A-Za-z]+([ '-][a-zA-Z]+)*")
	private String apellidos;
	
	private String dni;
	@NotEmpty
	@Email
	@Pattern(regexp="^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String correo;
	@ManyToOne
	@JoinColumn(name="idMascota")
	private Mascota mascota;
	private int telefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	
	@Temporal(TemporalType.DATE)
	private Date fechaReg;
	private int estado;
	

}
