package com.visitas.model.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the visitante database table.
 * 
 */
@Entity
@Table(name="visitante")
public class Visitante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String documento;

	@ManyToOne(fetch = FetchType.LAZY)
	private Eps eps;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private String genero;

	private String nombre;

	//bi-directional many-to-one association to Accesovisitante
	@OneToMany(mappedBy="visitante",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AccesoVisitante> accesovisitantes;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch = FetchType.LAZY)
	private Empresa empresa;

	public Visitante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Eps getEps() {
		return this.eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AccesoVisitante> getAccesovisitantes() {
		return this.accesovisitantes;
	}

	public void setAccesovisitantes(List<AccesoVisitante> accesovisitantes) {
		this.accesovisitantes = accesovisitantes;
	}

	public AccesoVisitante addAccesovisitante(AccesoVisitante accesovisitante) {
		getAccesovisitantes().add(accesovisitante);
		accesovisitante.setVisitante(this);

		return accesovisitante;
	}

	public AccesoVisitante removeAccesovisitante(AccesoVisitante accesovisitante) {
		getAccesovisitantes().remove(accesovisitante);
		accesovisitante.setVisitante(null);

		return accesovisitante;
	}

	public Empresa getEmpresaBean() {
		return this.empresa;
	}

	public void setEmpresaBean(Empresa empresaBean) {
		this.empresa = empresaBean;
	}

}