package com.visitas.model.entities;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String password;

	private String email;
	
	private String username;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch = FetchType.LAZY)
	private Empresa empresa;

	//bi-directional many-to-one association to Rol
	@ManyToOne(fetch = FetchType.LAZY)
	private Rol rol;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.password;
	}

	public void setClave(String clave) {
		this.password = clave;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return this.username;
	}

	public void setUsuario(String usuario) {
		this.username = usuario;
	}

	public Empresa getEmpresaBean() {
		return this.empresa;
	}

	public void setEmpresaBean(Empresa empresaBean) {
		this.empresa = empresaBean;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rolBean) {
		this.rol = rolBean;
	}

}