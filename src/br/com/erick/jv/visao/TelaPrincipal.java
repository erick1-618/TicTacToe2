package br.com.erick.jv.visao;

import javax.swing.JFrame;

import br.com.erick.jv.modelo.Grade;

public class TelaPrincipal extends JFrame{
	public TelaPrincipal() {
		Grade grade = new Grade();
		PainelGrade pg = new PainelGrade(grade);
		
		add(pg);
		
		setTitle("TicTacToe");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
	}
}
