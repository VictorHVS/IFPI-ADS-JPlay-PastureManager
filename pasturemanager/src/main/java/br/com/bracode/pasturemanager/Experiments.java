package br.com.bracode.pasturemanager;

import jplay.GameImage;
import jplay.Keyboard;
import br.com.bracode.experiment.Single;
import br.com.bracode.tools.Message;
import br.com.bracode.tools.Settings;

public class Experiments {

	private GameImage background;
	private GameImage title;

	private GameImage pastoIndividual;
	private GameImage pastoPrivado;
	private GameImage pastoColetivo;

	private GameImage close;
	private GameImage home;

	private String img;

	public Experiments() {
		init();
		loop();
	}

	private void init() {
		img = "media/img/";
		background = new GameImage(img + "bg_green.png");

		title = new GameImage(img + "title.png");
		title.x = background.width / 2 - title.width / 2;
		title.y = 39;

		pastoIndividual = new GameImage(img + "pastoIndividual.png");
		pastoIndividual.x = background.width / 2 - pastoIndividual.width / 2;
		pastoIndividual.y = 383;

		pastoPrivado = new GameImage(img + "pastoPrivado.png");
		pastoPrivado.x = background.width / 2 - pastoIndividual.width / 2;
		pastoPrivado.y = 492;

		pastoColetivo = new GameImage(img + "pastoColetivo.png");
		pastoColetivo.x = background.width / 2 - pastoIndividual.width / 2;
		pastoColetivo.y = 608;

		close = new GameImage(img + "close.png");
		close.x = background.width - close.width;
		close.y = 0;
		
		home = new GameImage(img + "home.png");
		home.x = background.width - home.width;
		home.y = close.height;
	}

	private void loop() {
		while (true) {
			draw();

			if (Settings.mouse.isOverObject(pastoIndividual)) {
				pastoIndividual.loadImage(img + "pastoIndividualHover.png");
			} else {
				pastoIndividual.loadImage(img + "pastoIndividual.png");
			}

			if (Settings.mouse.isOverObject(pastoPrivado)) {
				pastoPrivado.loadImage(img + "pastoPrivadoHover.png");
			} else {
				pastoPrivado.loadImage(img + "pastoPrivado.png");
			}

			if (Settings.mouse.isOverObject(pastoColetivo)) {
				pastoColetivo.loadImage(img + "pastoColetivoHover.png");
			} else {
				pastoColetivo.loadImage(img + "pastoColetivo.png");
			}
			
			
			checkClick();
			Settings.window.update();
		}
	}

	private void draw() {
		background.draw();
		title.draw();
		pastoIndividual.draw();
		pastoPrivado.draw();
		pastoColetivo.draw();
		close.draw();
		home.draw();
	}

	private void checkClick() {

		if (Settings.mouse.isOverObject(pastoIndividual) && Settings.mouse.isLeftButtonPressed()) {
			new Single();
		}
		
		if (Settings.mouse.isOverObject(close) && Settings.mouse.isLeftButtonPressed()) {
			Message.exit();
		}
		
		if (Settings.mouse.isOverObject(home) && Settings.mouse.isLeftButtonPressed()) {
			new Menu();
		}
		
		if (Settings.mouse.isOverObject(background) && Settings.mouse.isLeftButtonPressed()) {
			System.out.println("bg");
		}
		
		if(Settings.keyboard.keyDown(Keyboard.ESCAPE_KEY)){
			new Menu();
		}
		
	}
}