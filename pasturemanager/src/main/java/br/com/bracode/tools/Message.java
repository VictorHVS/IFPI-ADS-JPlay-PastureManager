package br.com.bracode.tools;

import java.awt.Color;

import javax.swing.JOptionPane;

import br.com.bracode.gui.Environment;
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
			Environment.resetPlayers();
			new Menu();
		}
	}
	
	public static void shortCodes(){
		
	}

	public static void wellcomeConsole(){
		String title = "Seja Bem vindo(a) ao Pasture Manager.";
		String dicas = "Antes de comerçar-mos fique atento as seguintes informações:";
		String line1 = "- Clique nas ovelhas para definir ações.";
		String line2 = "- A rodada finaliza a cada " + Settings.timeRodada + "s";
		String line3 = "- Ações geram pontos.";
		String line4 = "- Seja um bom pastor, cante uma musiquinha para elas.";
		String endMsg = "- Aperte Enter para iniciar...";
		int xReference = 284;
		int yReference = 572;
		
		Settings.window.drawText(title, xReference + 207, yReference + 25, Color.white, Settings.titleConsole);
		Settings.window.drawText(dicas, xReference + 58, yReference + 55, Color.white, Settings.console);
		
		Settings.window.drawText(line1, xReference + 58, yReference + 81, Color.white, Settings.console);
		Settings.window.drawText(line2, xReference + 58, yReference + 101, Color.white, Settings.console);
		Settings.window.drawText(line3, xReference + 58, yReference + 121, Color.white, Settings.console);
		Settings.window.drawText(line4, xReference + 58, yReference + 141, Color.white, Settings.console);
		
		Settings.window.drawText(endMsg, xReference + 538, yReference + 165, Color.white, Settings.console);
	}
}
