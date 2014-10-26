package br.com.bracode.experiment;

import java.awt.Color;

import javax.swing.JOptionPane;

import br.com.bracode.entity.Player;
import br.com.bracode.entity.Round;
import br.com.bracode.gui.Environment;
import br.com.bracode.tools.Settings;
import br.com.bracode.tools.Utils;

public class Single {

	Player player;

	private String 	name;
	private int		xNamePosition;
	
	private Round	round;
	
	public Single() {
		init();
		loop();
	}

	private void init() {
		String PlayerName;
		
		name 			= "Pasto Individual";
		xNamePosition 	= Settings.window.getWidth() / 2 - Utils.getWidthText(name, Settings.title) / 2; 
		
		PlayerName			= JOptionPane.showInputDialog(null, "Digite seu nome completo:", "Credenciamento - Nome", JOptionPane.QUESTION_MESSAGE);
		
		player = new Player(PlayerName, 1034, 5);
		
		round	= new Round(0, 0, 20);
		
	}

	private void loop() {
		while (true) {
			Environment.draw();
			Environment.checkclick();
			round.calculateRound();
			draw();
			Settings.window.update();
		}
	}

	private void draw() {
		Settings.window.drawText(name, xNamePosition, 48, Color.white, Settings.title);
		Settings.window.drawText(round.toString(), 705, 98, Color.white, Settings.subtitle);
		player.draw();

	}

}
