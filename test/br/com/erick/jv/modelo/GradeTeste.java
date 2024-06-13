package br.com.erick.jv.modelo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeTeste {
	Grade grade;
	
	@BeforeEach
	public void inicializarGrade() {
		this.grade = new Grade();
	}
	
	@Test
	public void testarVitoria() {
		grade.fazerJogada(0, 1);
		grade.fazerJogada(0, 0);
		grade.fazerJogada(1, 1);
		grade.fazerJogada(1, 0);
		grade.fazerJogada(2, 2);
		grade.fazerJogada(2, 0);
		assertTrue(grade.gameOver() == -1);
	}
	
	@Test
	public void testarEmpate() {
		grade.fazerJogada(0, 0);
		grade.fazerJogada(1, 1);
		grade.fazerJogada(1, 0);
		grade.fazerJogada(2, 0);
		grade.fazerJogada(0, 2);
		grade.fazerJogada(0, 1);
		grade.fazerJogada(1, 2);
		grade.fazerJogada(2, 2);
		grade.fazerJogada(2, 1);
		assertTrue(grade.gameOver() == 2);
	}
}
