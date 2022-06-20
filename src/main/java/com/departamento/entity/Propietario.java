package com.departamento.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table (name="propietario")
@Getter
@Setter
@ToString
public class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPropietario;
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
	private int telefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaReg;
	private int estado;

}