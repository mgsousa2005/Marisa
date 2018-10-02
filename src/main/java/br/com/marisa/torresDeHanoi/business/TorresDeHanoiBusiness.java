package br.com.marisa.torresDeHanoi.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TorresDeHanoiBusiness {	
	private String pinoOrigem;
	private String pinoDestino;
	private String pinoTrabalho;
	private static List<String> movimentos; 
	
	public TorresDeHanoiBusiness() {
		this.pinoOrigem = "Origem" ;
		this.pinoDestino = "Destino";
		this.pinoTrabalho = "Trabalho";
		TorresDeHanoiBusiness.movimentos = new ArrayList<>();
	}
	
	public int getMovimentos(int qtdDiscos) {
		TorresDeHanoiBusiness.movimentos = new ArrayList<>();
		TorresDeHanoiBusiness.hanoi(qtdDiscos, this.pinoOrigem, this.pinoDestino, this.pinoTrabalho);
		
		return this.getQtdMinimaMovimentos(qtdDiscos);
	}
	
	private int getQtdMinimaMovimentos(int qtdDiscos) {
		return (int) (Math.pow(2, qtdDiscos) - 1);
	}
	
	public StringBuilder getDescMovimentos() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < TorresDeHanoiBusiness.movimentos.size(); i++) {
			sb.append((i+1) + " - ");
			sb.append(TorresDeHanoiBusiness.movimentos.get(i));
			sb.append("\n");
		}
		
		return sb;		
	}
	
	private static void mover(String pinoOrigem, String pinoDestino) {
        System.out.println("Movimento: " + pinoOrigem + " -> " + pinoDestino);
    	TorresDeHanoiBusiness.movimentos.add("Movimento: " + pinoOrigem + " -> " + pinoDestino);        
    } 
	
	private static void hanoi(int qtdDiscos, String pinoOrigem, String pinoDestino, String pinotrabalho) {
		if (qtdDiscos > 0) {
			TorresDeHanoiBusiness.hanoi(qtdDiscos - 1, pinoOrigem, pinotrabalho, pinoDestino);
			TorresDeHanoiBusiness.mover(pinoOrigem, pinoDestino);
			TorresDeHanoiBusiness.hanoi(qtdDiscos - 1, pinotrabalho, pinoDestino, pinoOrigem);
        }
	}

}
