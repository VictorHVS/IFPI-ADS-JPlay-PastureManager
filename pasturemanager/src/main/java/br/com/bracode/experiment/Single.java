package br.com.bracode.experiment;

import java.awt.Color;

import javax.swing.JOptionPane;

import jplay.Keyboard;
import br.com.bracode.entity.Player;
import br.com.bracode.entity.Round;
import br.com.bracode.gui.Environment;
import br.com.bracode.tools.Message;
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
		Environment.addPlayer(player);
		
		apresentation();
		
		round	= new Round(0, 0, 20);
	}

	public void apresentation() {
		round		= new Round(1, 0, 0);
		String msg 	= "Aperte Enter Para Iniciar";
		int x		= Settings.window.getWidth() / 2 - Utils.getWidthText(msg, Settings.bigText) / 2;
		int y		= 328;
		while (true) {
			Environment.draw();
			Message.wellcomeConsole();
			draw();
			Settings.window.drawText(msg, x, y, Color.white, Settings.bigText);
			Settings.window.update();		
			if(Settings.keyboard.keyDown(Keyboard.ENTER_KEY)){
				break;
			}
		}
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
		Settings.window.drawText("Fase 01", xNamePosition, 98, Color.white, Settings.subtitle);
		player.draw();

	}

}
