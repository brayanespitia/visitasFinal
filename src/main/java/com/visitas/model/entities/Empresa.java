package com.visitas.model.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String code;

	private String endpoint;

	private byte estado;

	private String nombre;

	//bi-directional many-to-one association to Tipo
	@OneToMany(mappedBy="empresa",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Tipo> tipos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="empresa",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Usuario> usuarios;

	//bi-directional many-to-one association to Visitante
	@OneToMany(mappedBy="empresa",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Visitante> visitantes;

	public Empresa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEndpoint() {
		return this.endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tipo> getTipos() {
		return this.tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}

	public Tipo addTipo(Tipo tipo) {
		getTipos().add(tipo);
		tipo.setEmpresaBean(this);

		return tipo;
	}

	public Tipo removeTipo(Tipo tipo) {
		getTipos().remove(tipo);
		tipo.setEmpresaBean(null);

		return tipo;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setEmpresaBean(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setEmpresaBean(null);

		return usuario;
	}

	public List<Visitante> getVisitantes() {
		return this.visitantes;
	}

	public void setVisitantes(List<Visitante> visitantes) {
		this.visitantes = visitantes;
	}

	public Visitante addVisitante(Visitante visitante) {
		getVisitantes().add(visitante);
		visitante.setEmpresaBean(this);

		return visitante;
	}

	public Visitante removeVisitante(Visitante visitante) {
		getVisitantes().remove(visitante);
		visitante.setEmpresaBean(null);

		return visitante;
	}

}