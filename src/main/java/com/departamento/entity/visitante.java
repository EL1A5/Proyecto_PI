package com.departamento.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="visitante")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class visitante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvisitante;
	
	@NotEmpty
	@Pattern(regexp="[A-Za-z]+([ '-][a-zA-Z]+)*")
	private String nombre ;
	@NotEmpty
	@Pattern(regexp="[A-Za-z]+([ '-][a-zA-Z]+)*")
	private String apellidos ;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechanac;
	
	@NotNull
	
	private int dni; 
	@NotEmpty
	@Email
	@Pattern(regexp="^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String correo;
	@NotEmpty
	
	private String telefono;
	@Temporal(TemporalType.TIMESTAMP)
	private Date  fechareg  ;
	private int activo;

	

	
	
	
	
}
