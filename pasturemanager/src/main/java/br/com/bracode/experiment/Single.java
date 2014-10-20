package br.com.bracode.experiment;

import java.awt.Color;

import br.com.bracode.entity.Player;
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

		player = new Player();
		player.avatar.x = 1066;
		player.avatar.y = 12;

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
		player.avatar.draw();
		Settings.window.drawText(player.getNick(), 1067, 92, Color.white, Settings.userInfo);
		Settings.window.drawText(player.getScoreString(), 1067, 110, Color.white, Settings.userInfo);
		
	}

}
