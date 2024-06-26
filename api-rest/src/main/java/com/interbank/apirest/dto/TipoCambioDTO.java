package com.interbank.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class TipoCambioDTO {
	
	private Double monto;
	private String monedaOrigen;
	private String monedaDestino;
	
	
	private Double montoCambiado;
	private Double tipoCambio;
	
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	public Double getMontoCambiado() {
		return montoCambiado;
	}
	public void setMontoCambiado(Double montoCambiado) {
		this.montoCambiado = montoCambiado;
	}
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	

	
	
}
