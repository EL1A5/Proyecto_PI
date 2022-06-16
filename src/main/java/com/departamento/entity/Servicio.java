package com.departamento.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	private int estado;

}
