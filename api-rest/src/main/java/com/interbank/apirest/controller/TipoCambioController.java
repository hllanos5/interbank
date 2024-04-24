package com.interbank.apirest.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interbank.apirest.dto.TipoCambioDTO;
import com.interbank.apirest.service.TipoCambioService;
import com.interbank.apirest.model.TipoCambio;

@RestController
@RequestMapping("api/tipo-cambio")
public class TipoCambioController {
	
	@Autowired
	private TipoCambioService tipoCambioService;
	
	
	@PostMapping("/cambiar")
	public  ResponseEntity<?> cambiar(@RequestBody TipoCambioDTO tipoCambio) {
		
		try {
			TipoCambioDTO respuesta = tipoCambioService.cambiar(tipoCambio);

            return ResponseEntity.ok(Collections.singletonMap("cambio", respuesta));
		}
		catch (Exception e) {

            return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje", e.getMessage()));
        }		 
	}
	
	@GetMapping
	public ResponseEntity<?> getAllTipoCambio(){
		
		try {
			List<TipoCambio> respuesta = tipoCambioService.getAllTipoCambio();

            return ResponseEntity.ok(Collections.singletonMap("cambio", respuesta));
		}
		catch (Exception e) {

            return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje", e.getMessage()));
        }
	}

}
