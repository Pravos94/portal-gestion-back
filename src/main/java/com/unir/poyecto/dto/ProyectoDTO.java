/**
 * 
 */
package com.unir.poyecto.dto;

import java.util.Date;

/**
 * 
 */
public class ProyectoDTO {

	private Long id;
	private String nombre;
	private byte[] foto;
	private String descripcion;
	private String nivelExperiencia;
	private String requisitosTecnicos;
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
	 * @return the requisitosTecnicos
	 */
	public String getRequisitosTecnicos() {
		return requisitosTecnicos;
	}

	/**
	 * @param requisitosTecnicos the requisitosTecnicos to set
	 */
	public void setRequisitosTecnicos(String requisitosTecnicos) {
		this.requisitosTecnicos = requisitosTecnicos;
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
