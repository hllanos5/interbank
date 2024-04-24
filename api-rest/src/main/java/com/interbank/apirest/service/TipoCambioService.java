package com.interbank.apirest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interbank.apirest.dto.FeignDTO;
import com.interbank.apirest.dto.TipoCambioDTO;
import com.interbank.apirest.feign.client.FeignClientApp;
import com.interbank.apirest.model.TipoCambio;
import com.interbank.apirest.repository.TipoCambioRepository;

@Component
public class TipoCambioService {
	@Autowired
	private TipoCambioRepository tipoCambioRepository;
	
	@Autowired
	private FeignClientApp userFeignClientApp;
	
	public TipoCambio createTipoCambio(TipoCambio tipoCambio) {
		return tipoCambioRepository.save(tipoCambio);
	}
	
	public TipoCambioDTO cambiar(TipoCambioDTO obj) {
		
		TipoCambioDTO resultado = new TipoCambioDTO();
		
		FeignDTO datosTipoCambio = userFeignClientApp.getUsdRate(obj.getMonedaOrigen());
		
		
		if (datosTipoCambio!=null) {
		    //TipoCambio encontrado
			HashMap<String,Double> rates = datosTipoCambio.getRates();
			Double tipoCambio = Double.parseDouble(String.valueOf(rates.get(obj.getMonedaDestino())));
			
			if( tipoCambio != null) {
				//Proceso de cambio
				Double conversionTipoCambio = tipoCambio;
				String monedaDestino = obj.getMonedaDestino();
				
				resultado.setMonto(obj.getMonto());
				resultado.setMontoCambiado(obj.getMonto() * conversionTipoCambio );
				resultado.setMonedaOrigen(obj.getMonedaOrigen());
			    resultado.setMonedaDestino(obj.getMonedaDestino());
			    resultado.setTipoCambio(conversionTipoCambio);
			    
			    TipoCambio oTipoCambio = new TipoCambio();
			    oTipoCambio.setMonedaOrigen(resultado.getMonedaOrigen());
			    oTipoCambio.setMonedaDestino(resultado.getMonedaDestino());
			    oTipoCambio.setMonto(resultado.getMonto());
			    oTipoCambio.setMontoCambiado(resultado.getMontoCambiado());
			    oTipoCambio.setTipoCambio(resultado.getTipoCambio());
			    
			    tipoCambioRepository.save(oTipoCambio);
			}			
		    
		}
		
		return resultado;
	}
	
	public List<TipoCambio> getAllTipoCambio() {
		 return tipoCambioRepository.findAll();
	}

}
