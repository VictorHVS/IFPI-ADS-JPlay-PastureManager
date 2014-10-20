package br.com.bracode.tools;

import javax.swing.JOptionPane;

import br.com.bracode.pasturemanager.Menu;

public class Message {

	public static void exit() {
		int op = JOptionPane.showConfirmDialog(null,
				"Você deseja mesmo fechar?\nSe estiver em jogo, todo o progresso será perdido",
				"Pasture Manager [Fechar]", JOptionPane.CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);

		if (op == 0) {
			Settings.window.exit();
		}

	}

	public static void home() {
		int op = JOptionPane.showConfirmDialog(null,
				"Deseja voltar ao menu inicial?\nTodo o progresso deste jogo será perdido",
				"Pasture Manager [Voltar]", JOptionPane.CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);

		if (op == 0) {
			new Menu();
		}
	}
}
