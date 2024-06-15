package br.com.erick.jv.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.erick.jv.modelo.Grade;

@SuppressWarnings("serial")
public class Placar extends JPanel{
	private int vitoriasX = 0;
	private int vitoriasO = 0;
	private JPanel panelX;
	private JPanel panelO;
	private JLabel labelX;
	private JLabel labelO;
	public Placar(Grade g) {
		setBackground(Color.LIGHT_GRAY);
		labelX = new JLabel("vitória do X: " + this.vitoriasX);
		labelO = new JLabel("vitórias do O: " + this.vitoriasO);
		
		labelX.setForeground(Color.BLACK);
		labelO.setForeground(Color.BLACK);
		
		panelX = new JPanel();
		panelX.setBackground(new Color(101, 210, 255));
		panelX.add(labelX);
		
		panelO = new JPanel();
		panelO.setBackground(new Color(255, 102, 102));
		panelO.add(labelO);
		
		setLayout(new GridLayout());
		
		g.registrarObservadores(v -> {
			if(v == 1) {
				this.vitoriasX++;
			}else if(v == -1){
				this.vitoriasO++;
			}
			labelX.setText("vitórias do X: " + this.vitoriasX);
			labelO.setText("vitórias do O: " + this.vitoriasO);
		});
		
		add(panelX);
		add(panelO);
	}
}
