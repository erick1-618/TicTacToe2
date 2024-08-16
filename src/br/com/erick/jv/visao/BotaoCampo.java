package br.com.erick.jv.visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import br.com.erick.jv.modelo.Campo;
import br.com.erick.jv.modelo.CampoEventos;
import br.com.erick.jv.modelo.CampoObservador;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador, MouseListener{
	private Campo campo;
	private final Color BG_PADRAO = Color.LIGHT_GRAY;
	
	public BotaoCampo(Campo c) {
		this.campo = c;
		setBackground(BG_PADRAO);
		setText("");
		setFont(new Font("Arial", Font.BOLD, 40));
		addMouseListener(this);
		campo.registrarObservador(this, 0);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1) {
			this.campo.grade.fazerJogada(campo.getCord()[0], campo.getCord()[1]);
		}
	}
	
	@Override
	public void eventoOcorreu(Campo c, CampoEventos e) {
		if(e == CampoEventos.JOGADA) {
			aplicarJogada();
		}else {
			reiniciarBotao();
		}
	}
	
	public void aplicarJogada() {
		if(campo.isMarcado()) {
			if(this.campo.grade.getVez() == 1) {
				setText("X");
			}else {
				setText("O");
			}
			this.campo.grade.alternarVez();			
		}
	}
	
	public void reiniciarBotao() {
		setText("");
	}

	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}
