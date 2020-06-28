package com.visitas.model.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modalidad database table.
 * 
 */
@Entity
@Table(name="modalidad")
public class Modalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Basico
	@OneToMany(mappedBy="modalidad",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Basico> basicos;

	public Modalidad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Basico> getBasicos() {
		return this.basicos;
	}

	public void setBasicos(List<Basico> basicos) {
		this.basicos = basicos;
	}

	public Basico addBasico(Basico basico) {
		getBasicos().add(basico);
		basico.setModalidadBean(this);

		return basico;
	}

	public Basico removeBasico(Basico basico) {
		getBasicos().remove(basico);
		basico.setModalidadBean(null);

		return basico;
	}

}