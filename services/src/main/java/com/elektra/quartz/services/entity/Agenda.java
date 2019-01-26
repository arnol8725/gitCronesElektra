package com.elektra.quartz.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGENDA")
/*@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "detAgendaProcedure",
procedureName = "ARNOL.PAAGENDA.GETAGENDA",
resultClasses = Agenda.class,
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = "idSS", type = Long.class),
    @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "rspCursor", type = Class.class)

}
)})*/
public class Agenda implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name="ID")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="agen")
	//  @SequenceGenerator(name="agen", sequenceName="agen", allocationSize=1)
	public int id;
	@Column(name="NOMBRE")
	public String nombre;
	@Column(name="APELLIDOPAT")
	public String apellidoPat;
	@Column(name="APELLIDOMAT")
	public String apellidoMat;
	@Column(name="TELEFONO")
	public String telefono;
	@Column(name="CELULAR")
	public String celular;
	@Column(name="EMAIL")
	public String email;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPat() {
		return apellidoPat;
	}
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}
	public String getApellidoMat() {
		return apellidoMat;
	}
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Agenda(int id, String nombre, String apellidoPat, String apellidoMat, String telefono, String celular,
			String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.telefono = telefono;
		this.celular = celular;
		this.email = email;
	}
	public Agenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Agenda [id=" + id + ", nombre=" + nombre + ", apellidoPat=" + apellidoPat + ", apellidoMat="
				+ apellidoMat + ", telefono=" + telefono + ", celular=" + celular + ", email=" + email + "]";
	}
	
	
	
}
