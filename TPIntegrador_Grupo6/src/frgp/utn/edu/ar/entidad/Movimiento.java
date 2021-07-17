package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nroTx;

	private int cbuOrigen;
	private int cbuDestino;
	private String fecha;
	private String detalle;
	private Double saldo;

	public Movimiento() {

	}

	public int getCbuOrigen() {
		return cbuOrigen;
	}

	public void setCbuOrigen(int cbuOrigen) {
		this.cbuOrigen = cbuOrigen;
	}

	public int getCbuDestino() {
		return cbuDestino;
	}

	public void setCbuDestino(int cbuDestino) {
		this.cbuDestino = cbuDestino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
