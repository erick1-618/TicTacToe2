package br.com.erick.jv.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Grade implements CampoObservador{
	public Campo[][] campos = new Campo[3][3];
	private int vez = 1;
	private List<Consumer<Integer>> observadores= new ArrayList();
	
	public Grade() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				campos[i][j] = new Campo(i, j, this);
				campos[i][j].registrarObservador(this, 1);
			}
		}
	}
	
	public boolean todosMarcados() {
		boolean check = true;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				check = check & this.campos[i][j].isMarcado();
			}
		}
		return check;
	}
	
	public void alternarVez() {
		vez = - vez;
	}
	
	public void registrarObservadores(Consumer<Integer> o) {
		this.observadores.add(o);
	}
	
	public int getVez() {
		return vez;
	}

	private void notificarObservadores(int vencedor) {
		this.observadores.forEach(o -> o.accept(vencedor));
	}
	
	public void reiniciar() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				campos[i][j].reiniciar();
			}
		}
	}
	
	public void fazerJogada(int x, int y) {
		if(!campos[x][y].isMarcado()) {
			campos[x][y].marcar(vez);
		}
	}
	
	//1 vitória do X, -1 vitória do O, 2 empate
	public int gameOver() {
		Predicate<Integer> SomaDosCampos = n -> {
			if(n != 0) {
				return n % 3 == 0;				
			}else {
				return false;
			}
		};
		Predicate<Integer> marcado = n -> n != 0;
		List<Integer> resultadosDaMatriz = new ArrayList();
		
		int a1 = campos[0][0].getMarca() + campos[0][1].getMarca() + campos[0][2].getMarca();   
		int a2 = campos[1][0].getMarca() + campos[1][1].getMarca() + campos[1][2].getMarca();
		int a3 = campos[2][0].getMarca() + campos[2][1].getMarca() + campos[2][2].getMarca();
		int a4 = campos[0][0].getMarca() + campos[1][0].getMarca() + campos[2][0].getMarca();
		int a5 = campos[0][1].getMarca() + campos[1][1].getMarca() + campos[2][1].getMarca();
		int a6 = campos[0][2].getMarca() + campos[1][2].getMarca() + campos[2][2].getMarca();
		int a7 = campos[0][0].getMarca() + campos[1][1].getMarca() + campos[2][2].getMarca();
		int a8 = campos[0][2].getMarca() + campos[1][1].getMarca() + campos[2][0].getMarca();
		
		resultadosDaMatriz.add(a1);
		resultadosDaMatriz.add(a2);
		resultadosDaMatriz.add(a3);
		resultadosDaMatriz.add(a4);
		resultadosDaMatriz.add(a5);
		resultadosDaMatriz.add(a6);
		resultadosDaMatriz.add(a7);
		
		if(resultadosDaMatriz.stream().anyMatch(SomaDosCampos)) {
			Optional<Integer> x = resultadosDaMatriz.stream().filter(SomaDosCampos).findFirst();
			this.vez = x.get() / 3;
			notificarObservadores(this.vez);
			return this.vez;
		}else if(todosMarcados()) {
			notificarObservadores(2);
			return 2;
		}
		return 0;
	}

	@Override
	public void eventoOcorreu(Campo c, CampoEventos e) {
		if(e == CampoEventos.JOGADA) {
			gameOver();
		}
	}
}
