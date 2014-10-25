package br.com.bracode.experiment;

import java.awt.Color;

import javax.swing.JOptionPane;

import br.com.bracode.entity.Player;
import br.com.bracode.gui.Environment;
import br.com.bracode.tools.Settings;

public class Single {

	Player player;

	private String name;

	public Single() {
		init();
		loop();
	}

	private void init() {

		name = "Pasto Individual";
		String name = JOptionPane.showInputDialog(null,
				"Digite seu nome completo:", "Credenciamento - Nome",
				JOptionPane.QUESTION_MESSAGE);
		
		player = new Player(name, 1034, 5);

	}

	private void loop() {
		while (true) {
			Environment.draw();
			Environment.checkclick();
			draw();

			Settings.window.update();
		}
	}

	private void draw() {
		Settings.window.drawText(name, 548, 45, Color.white, Settings.title);
		player.draw();

	}

}
