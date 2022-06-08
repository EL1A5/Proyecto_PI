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
@Table(name = "servicio")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idservicio;
	
	private String nombreserv;
	private double precioserv;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechareg;
	private int estado;

}
