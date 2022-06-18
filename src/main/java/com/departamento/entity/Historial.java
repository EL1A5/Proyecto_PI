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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="historial")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Historial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idhistorial ;
	@ManyToOne
	@JoinColumn(name = "idincidencia")
	private Insidencia insidencia; 
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "iddepartamento")
	private Departamento departamento;
	
	private String descripcion ;
	private int estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechareg ;
	
	
}
