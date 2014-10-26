package br.com.bracode.pasturemanager;

import jplay.GameImage;
import jplay.Keyboard;
import br.com.bracode.tools.Message;
import br.com.bracode.tools.Settings;

public class Menu {

	private GameImage background;
	private GameImage title;

	private GameImage jogar;
	private GameImage configuracoes;
	private GameImage creditos;

	private GameImage close;

	public Menu() {
		init();
		loop();
	}

	private void init() {
		background = new GameImage(Settings.img + "bg_green.png");

		title = new GameImage(Settings.img + "title.png");
		title.x = background.width / 2 - title.width / 2;
		title.y = 39;

		close = new GameImage(Settings.img + "close.png");
		close.x = background.width - close.width;
		close.y = 0;

		jogar = new GameImage(Settings.img + "jogar.png");
		jogar.x = background.width / 2 - jogar.width / 2;
		jogar.y = 383;

		configuracoes = new GameImage(Settings.img + "configuracoes.png");
		configuracoes.x = background.width / 2 - jogar.width / 2;
		configuracoes.y = 492;

		creditos = new GameImage(Settings.img + "creditos.png");
		creditos.x = background.width / 2 - jogar.width / 2;
		creditos.y = 608;
	}

	private void loop() {
		while (true) {
			draw();
			checkHover();
			checkClick();

			Settings.window.update();
		}
	}

	private void checkHover() {
		if (Settings.mouse.isOverObject(jogar)) {
			jogar.loadImage(Settings.img + "jogarHover.png");
		} else {
			jogar.loadImage(Settings.img + "jogar.png");
		}

		if (Settings.mouse.isOverObject(configuracoes)) {
			configuracoes.loadImage(Settings.img + "configuracoesHover.png");
		} else {
			configuracoes.loadImage(Settings.img + "configuracoes.png");
		}

		if (Settings.mouse.isOverObject(creditos)) {
			creditos.loadImage(Settings.img + "creditosHover.png");
		} else {
			creditos.loadImage(Settings.img + "creditos.png");
		}
	}

	private void draw() {
		background.draw();
		title.draw();
		jogar.draw();
		configuracoes.draw();
		creditos.draw();
		close.draw();
	}

	private void checkClick() {

		if (Settings.mouse.isOverObject(close) && Settings.mouse.isLeftButtonPressed()) {
			Settings.window.exit();
		}
		
		if (Settings.mouse.isOverObject(jogar) && Settings.mouse.isLeftButtonPressed()) {
			new Experiments();
		}
		
		if (Settings.mouse.isOverObject(configuracoes) && Settings.mouse.isLeftButtonPressed()) {
			
		}
		if(Settings.keyboard.keyDown(Keyboard.ESCAPE_KEY)){
			Message.exit();
		}
				
		if (Settings.mouse.isOverObject(creditos) && Settings.mouse.isLeftButtonPressed()) {
			new Credits();
		}
		
		if (Settings.mouse.isOverObject(background) && Settings.mouse.isLeftButtonPressed()) {
			System.out.println("bg");
		}

	}

}
