package br.com.erick.jv.visao;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;

import br.com.erick.jv.modelo.Grade;

@SuppressWarnings("serial")
public class Placar extends JLabel{
	private int vitoriasX = 0;
	private int vitoriasO = 0;
	private JLabel label;
	public Placar(Grade g) {
		setBackground(Color.LIGHT_GRAY);
		label = new JLabel("vitória do X: " + this.vitoriasX + " | vitórias do O: " + this.vitoriasO);
		label.setForeground(Color.BLACK);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		g.registrarObservadores(v -> {
			if(v == 1) {
				this.vitoriasX++;
			}else if(v == -1){
				this.vitoriasO++;
			}
			label.setText("vitórias do X: " + this.vitoriasX + " | vitórias do O: " + this.vitoriasO);
		});
		
		add(label);
	}
}
