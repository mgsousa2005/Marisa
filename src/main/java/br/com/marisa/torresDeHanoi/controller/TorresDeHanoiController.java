package br.com.marisa.torresDeHanoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.marisa.torresDeHanoi.business.TorresDeHanoiBusiness;

/**
 * Controller do servico rest, endereço: http://localhost:8080/torresDeHanoi/XXXX
 * 
 * Onde XXXX é a quantidade de discos empilhados
 * @author mGomes
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class TorresDeHanoiController {

	@Autowired
	TorresDeHanoiBusiness service;	
	
	@CrossOrigin(origins = "*")
    @GetMapping(value = "/torresDeHanoi/{qtdDiscos}", produces = {"application/json"})
    public ResponseEntity<?> gets(@PathVariable("qtdDiscos") String qtdDiscos) {
    	String resultado = null;
    	
    	try {
    		Integer qtd = Integer.valueOf(qtdDiscos); 
    		
    		if(qtd < 0) {
    			throw new Exception("Quantidade de discos inválida.");
    		}
    		
    		int qtdMovimentos = service.getMovimentos(qtd);
    		StringBuilder descMovimentos = service.getDescMovimentos();
    		descMovimentos.append("\n");    		
    		descMovimentos.append("Quantidade mínima de movimentos: " + qtdMovimentos);
    		
    		resultado = descMovimentos.toString();
    	} 
    	catch(NumberFormatException e) {
    		return new ResponseEntity<String>("ERRO: Formato de número inválido.", HttpStatus.INTERNAL_SERVER_ERROR);	
    	} 
    	catch (Exception e) {
    		return new ResponseEntity<String>("ERRO: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    	return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }
	
	
}
