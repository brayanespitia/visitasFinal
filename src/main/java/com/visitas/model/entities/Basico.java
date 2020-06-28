package com.visitas.model.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the basico database table.
 * 
 */
@Entity
@Table(name="basico")
public class Basico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String contactonombre;

	private String contactotelefono;

	private String documento;

	private byte embarazo;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private Timestamp fechareg;

	private String genero;

	private byte mas60;

	private byte menos15;

	private String nombre;

	private byte salud;

	private String telefono;

	//bi-directional many-to-one association to Ep
	@ManyToOne(fetch = FetchType.LAZY)
	private Eps eps;

	//bi-directional many-to-one association to Modalidad
	@ManyToOne(fetch = FetchType.LAZY)
	private Modalidad modalidad;

	//bi-directional many-to-one association to Tipo
	@ManyToOne(fetch = FetchType.LAZY)	
	private Tipo tipo;



	//bi-directional many-to-one association to Registro
	@OneToMany(mappedBy="persona",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Registro> registros;

	public Basico() {
	}
	
	
	@PrePersist
	public void prePersist() {
		Date d= new Date();
		fechareg = new Timestamp(d.getTime());
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactonombre() {
		return this.contactonombre;
	}

	public void setContactonombre(String contactonombre) {
		this.contactonombre = contactonombre;
	}

	public String getContactotelefono() {
		return this.contactotelefono;
	}

	public void setContactotelefono(String contactotelefono) {
		this.contactotelefono = contactotelefono;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public byte getEmbarazo() {
		return this.embarazo;
	}

	public void setEmbarazo(byte embarazo) {
		this.embarazo = embarazo;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public byte getMas60() {
		return this.mas60;
	}

	public void setMas60(byte mas60) {
		this.mas60 = mas60;
	}

	public byte getMenos15() {
		return this.menos15;
	}

	public void setMenos15(byte menos15) {
		this.menos15 = menos15;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getSalud() {
		return this.salud;
	}

	public void setSalud(byte salud) {
		this.salud = salud;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Eps getEps() {
		return this.eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}

	public Modalidad getModalidadBean() {
		return this.modalidad;
	}

	public void setModalidadBean(Modalidad modalidadBean) {
		this.modalidad = modalidadBean;
	}

	public Tipo getTipoBean() {
		return this.tipo;
	}

	public void setTipoBean(Tipo tipoBean) {
		this.tipo = tipoBean;
	}

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public Registro addRegistro(Registro registro) {
		getRegistros().add(registro);
		registro.setBasico(this);

		return registro;
	}

	public Registro removeRegistro(Registro registro) {
		getRegistros().remove(registro);
		registro.setBasico(null);

		return registro;
	}

}