package br.com.erick.jv.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.erick.jv.modelo.Grade;

public class PainelGrade extends JPanel{
	public PainelGrade(Grade g) {
		setLayout(new GridLayout(3, 3));
		for(int i = 0; i < 3; i++) {
			for(int j =0; j < 3; j++) {
				add(new BotaoCampo(g.campos[i][j]));
			}
		}
		g.registrarObservadores(vencedor -> {
			if(vencedor == 1) {
				JOptionPane.showMessageDialog(this, "Vitória do X!");
			}else {
				if(vencedor == -1) {
					JOptionPane.showMessageDialog(this, "Vitória do Círculo!");
				}
				else {
					JOptionPane.showMessageDialog(this, "Empate!");
				}
			}
			g.reiniciar();
		});
	}
}
