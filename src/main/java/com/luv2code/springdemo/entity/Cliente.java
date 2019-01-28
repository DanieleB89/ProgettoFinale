package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="clienti")
public class Cliente {
	
	private int idcliente;
	private String ragionesociale;
	private String iva;
	private String email;
	private String indirizzo;
	private String tipologia;
	private int idContatto;
	private String note;
	
	
	public Cliente() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcliente")
	public int getidcliente() {
		return idcliente;
	}

	public void setidcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	@Column(name="ragionesociale")
	public String getragionesociale() {
		return ragionesociale;
	}

	public void setragionesociale(String ragionesociale) {
		this.ragionesociale = ragionesociale;
	}

	@Column(name="iva")
	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="indirizzo")
	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Column(name="tipologia")
	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	@Column(name="idcontatto")
	public int getidcontatto() {
		return idContatto;
	}

	public void setidcontatto(int idContatto) {
		this.idContatto = idContatto;
	}

	@Column(name="note")
	public String getnote() {
		return note;
	}

	public void setnote(String note) {
		this.note = note;
	}
	
	/*@Override
	public String toString() {
		return "Cliente [id=" + idCliente + ", nome=" + ragioneSociale + ", prezzo=" + prezzo + ", durata=" + durata + "]";
	}*/
	
		
}
