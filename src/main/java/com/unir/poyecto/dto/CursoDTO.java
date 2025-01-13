/**
 * 
 */
package com.unir.poyecto.dto;

import java.util.Date;

/**
 * 
 */
public class CursoDTO {

	private Long id;
	private String nombre;
	private byte[] foto;
	private String descripcion;
	private String nivelExperiencia;
	private String temario;
	private String profesor;
	private String metodologia;
	private String dificultad;
	private Date ultimaActualizacion;
	private boolean destacado;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the foto
	 */
	public byte[] getFoto() {
		return foto;
	}
	/**
	 * @param foto the foto to set
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the nivelExperiencia
	 */
	public String getNivelExperiencia() {
		return nivelExperiencia;
	}
	/**
	 * @param nivelExperiencia the nivelExperiencia to set
	 */
	public void setNivelExperiencia(String nivelExperiencia) {
		this.nivelExperiencia = nivelExperiencia;
	}
	/**
	 * @return the temario
	 */
	public String getTemario() {
		return temario;
	}
	/**
	 * @param temario the temario to set
	 */
	public void setTemario(String temario) {
		this.temario = temario;
	}
	/**
	 * @return the profesor
	 */
	public String getProfesor() {
		return profesor;
	}
	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	/**
	 * @return the metodologia
	 */
	public String getMetodologia() {
		return metodologia;
	}
	/**
	 * @param metodologia the metodologia to set
	 */
	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}
	/**
	 * @return the dificultad
	 */
	public String getDificultad() {
		return dificultad;
	}
	/**
	 * @param dificultad the dificultad to set
	 */
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	/**
	 * @return the ultimaActualizacion
	 */
	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}
	/**
	 * @param ultimaActualizacion the ultimaActualizacion to set
	 */
	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}
	/**
	 * @return the destacado
	 */
	public boolean isDestacado() {
		return destacado;
	}
	/**
	 * @param destacado the destacado to set
	 */
	public void setDestacado(boolean destacado) {
		this.destacado = destacado;
	}

	
	
}
