package com.visitas.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the eps database table.
 * 
 */
@Entity
@Table(name = "eps")
public class Eps implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	// bi-directional many-to-one association to Basico
	@OneToMany(mappedBy = "eps", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Basico> basicos;

	// bi-directional many-to-one association to Basico
	@OneToMany(mappedBy = "eps", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Visitante> visitantes;

	public Eps() {
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
		basico.setEps(this);

		return basico;
	}

	public Basico removeBasico(Basico basico) {
		getBasicos().remove(basico);
		basico.setEps(null);

		return basico;
	}

	public List<Visitante> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(List<Visitante> visitantes) {
		this.visitantes = visitantes;
	}


	
	public Visitante addBasico(Visitante visitante) {
		getVisitantes().add(visitante);
		visitante.setEps(this);

		return visitante;
	}

	public Visitante removeBasico(Visitante visitante) {
		getVisitantes().remove(visitante);
		visitante.setEps(null);

		return visitante;
	}
	
}