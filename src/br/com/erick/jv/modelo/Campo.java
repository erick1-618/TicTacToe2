package br.com.erick.jv.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	public Grade grade;
	public int[] getCord() {
		return cord;
	}

	private boolean marcado;
	private int marca;
	private int[] cord = new int[2];
	private CampoObservador[] observadores = new CampoObservador[2];
	
	public Campo(int x, int y, Grade g) {
		this.grade = g;
		this.cord[0] = x;
		this.cord[1] = y;
	}
	
	// -1 é equivalente ao círculo e 1 é equivalente ao X
	public void marcar(int marca) {
		if(!this.marcado) {
			this.marca = marca;
			this.marcado = true;
			notificarObservadores(CampoEventos.JOGADA);
		}
	}
	
	public boolean isMarcado() {
		return this.marcado;
	}
	
	public int getMarca() {
		return this.marca;
	}

	public void reiniciar() {
		this.marcado = false;
		this.marca = 0;
		notificarObservadores(CampoEventos.REINICIO);
	}
	
	public void registrarObservador(CampoObservador o, int pos) {
		this.observadores[pos] = o;
	}
	
	private void notificarObservadores(CampoEventos e) {
		for(int i = 0; i < 2; i++) {
			this.observadores[i].eventoOcorreu(this, e);
		}
	}
}
