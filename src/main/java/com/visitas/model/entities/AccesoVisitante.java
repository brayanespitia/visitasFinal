package com.visitas.model.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the accesovisitante database table.
 * 
 */
@Entity
@Table(name="accesovisitante")
public class AccesoVisitante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private float temperatura;

	//bi-directional many-to-one association to Visitante
	@ManyToOne(fetch = FetchType.LAZY)	
	private Visitante visitante;

	public AccesoVisitante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public Visitante getVisitante() {
		return this.visitante;
	}

	public void setVisitante(Visitante visitanteBean) {
		this.visitante = visitanteBean;
	}

}