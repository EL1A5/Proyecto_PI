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
	private int idmascota;
	private int idresidente;
	private String tipo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechareg;
	private int activo;
	
	
}











