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

@Entity
@Table(name = "departamento")
public class Departamento {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddepartamento;
	private int idpropietario;
	private int numpiso;
	private int habitaciones;
	private int cocinas;
	private int banos;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechareg;
	private String estado;
	private int activo;
	
	
	public int getIddepartamento() {
		return iddepartamento;
	}
	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}
	public int getIdpropietario() {
		return idpropietario;
	}
	public void setIdpropietario(int idpropietario) {
		this.idpropietario = idpropietario;
	}
	public int getNumpiso() {
		return numpiso;
	}
	public void setNumpiso(int numpiso) {
		this.numpiso = numpiso;
	}
	public int getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}
	public int getCocinas() {
		return cocinas;
	}
	public void setCocinas(int cocinas) {
		this.cocinas = cocinas;
	}
	public int getBanos() {
		return banos;
	}
	public void setBanos(int banos) {
		this.banos = banos;
	}
	public Date getFechareg() {
		return fechareg;
	}
	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	@Override
	public String toString() {
		return "Departamento [iddepartamento=" + iddepartamento + ", idresidente=" + idpropietario + ", numpiso="
				+ numpiso + ", habitaciones=" + habitaciones + ", cocinas=" + cocinas + ", banos=" + banos
				+ ", fechareg=" + fechareg + ", estado=" + estado + ", activo=" + activo + "]";
	}
	
	

}
