package br.com.erick.jv.visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import br.com.erick.jv.modelo.Grade;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame{
	public TelaPrincipal() {
		Grade grade = new Grade();
		Placar p = new Placar(grade);
		PainelGrade pg = new PainelGrade(grade);
		
		setLayout(new BorderLayout());
		p.setPreferredSize(new Dimension(400, 33));
		add(p, BorderLayout.NORTH);
		pg.setPreferredSize(new Dimension(400, 400));
		add(pg, BorderLayout.CENTER);
		
		setTitle("TicTacToe");
		setSize(400, 433);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
	}
}
