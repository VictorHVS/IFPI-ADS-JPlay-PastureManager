package br.com.bracode.pasturemanager;

import jplay.GameImage;
import jplay.Mouse;
import jplay.Window;

public class Menu {

	public static Window window;
	private Mouse mouse;

	private GameImage background;
	private GameImage title;

	private GameImage jogar;
	private GameImage configuracoes;
	private GameImage creditos;

	private GameImage close;

	private String img;

	public Menu() {
		init();
		loop();
	}

	private void init() {
		img = "media/img/";
		window = new Window(1366, 768);
		mouse = window.getMouse();
		background = new GameImage(img + "bg_green.png");

		title = new GameImage(img + "title.png");
		title.x = background.width / 2 - title.width / 2;
		title.y = 39;

		close = new GameImage(img + "close.png");
		close.x = background.width - close.width;
		close.y = 0;

		jogar = new GameImage(img + "jogar.png");
		jogar.x = background.width / 2 - jogar.width / 2;
		jogar.y = 383;

		configuracoes = new GameImage(img + "configuracoes.png");
		configuracoes.x = background.width / 2 - jogar.width / 2;
		configuracoes.y = 492;

		creditos = new GameImage(img + "creditos.png");
		creditos.x = background.width / 2 - jogar.width / 2;
		creditos.y = 608;
	}

	private void loop() {
		while (true) {
			draw();
			checkHover();
			checkClick();

			window.update();
		}
	}

	private void checkHover() {
		if (mouse.isOverObject(jogar)) {
			jogar.loadImage(img + "jogarHover.png");
		} else {
			jogar.loadImage(img + "jogar.png");
		}

		if (mouse.isOverObject(configuracoes)) {
			configuracoes.loadImage(img + "configuracoesHover.png");
		} else {
			configuracoes.loadImage(img + "configuracoes.png");
		}

		if (mouse.isOverObject(creditos)) {
			creditos.loadImage(img + "creditosHover.png");
		} else {
			creditos.loadImage(img + "creditos.png");
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

		if (mouse.isOverObject(close) && mouse.isLeftButtonPressed()) {
			window.exit();
		}
		
		if (mouse.isOverObject(jogar) && mouse.isLeftButtonPressed()) {
			new ExperimentScreen();
		}
		
		if (mouse.isOverObject(configuracoes) && mouse.isLeftButtonPressed()) {
			
		}
		
		if (mouse.isOverObject(creditos) && mouse.isLeftButtonPressed()) {
			new Credits();
		}
		
		if (mouse.isOverObject(background) && mouse.isLeftButtonPressed()) {
			System.out.println("bg");
		}

	}

}
