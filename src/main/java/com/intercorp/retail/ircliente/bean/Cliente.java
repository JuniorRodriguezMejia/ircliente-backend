package com.intercorp.retail.ircliente.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Cliente {
	
	@Id
	private String id;
	@NotBlank(message = "nombre es obligatorio")
	private String nombre;
	@NotBlank(message = "apellido es obligatorio")
	private String apellido;
	@NotBlank(message = "fechaNacimiento es obligatorio")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
	private String fechaNacimiento;
	private Integer edad;
	private String fechaProbableMuerte;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	public String getFechaProbableMuerte() {
		return fechaProbableMuerte;
	}
	
	public void setFechaProbableMuerte(String fechaProbableMuerte) {
		this.fechaProbableMuerte = fechaProbableMuerte;
	}	

}
