package br.com.bracode.pasturemanager;

import jplay.GameImage;
import jplay.Mouse;
import jplay.Window;

public class ExperimentScreen {

	private Window 		window;
	private Mouse 		mouse;

	private GameImage 	background;
	private GameImage 	title;

	private GameImage 	pastoIndividual;
	private GameImage 	pastoPrivado;
	private GameImage 	pastoColetivo;

	private String 		img;

	public ExperimentScreen() {
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
		title.y = 50;

		pastoIndividual = new GameImage(img + "pastoIndividual.png");
		pastoIndividual.x = background.width / 2 - pastoIndividual.width / 2;
		pastoIndividual.y = 383;

		pastoPrivado = new GameImage(img + "pastoPrivado.png");
		pastoPrivado.x = background.width / 2 - pastoIndividual.width / 2;
		pastoPrivado.y = 492;

		pastoColetivo = new GameImage(img + "pastoColetivo.png");
		pastoColetivo.x = background.width / 2 - pastoIndividual.width / 2;
		pastoColetivo.y = 608;
	}

	private void loop() {
		while (true) {
			draw();

			if (mouse.isOverObject(pastoIndividual)) {
				pastoIndividual.loadImage(img + "pastoIndividualHover.png");
			} else {
				pastoIndividual.loadImage(img + "pastoIndividual.png");
			}

			if (mouse.isOverObject(pastoPrivado)) {
				pastoPrivado.loadImage(img + "pastoPrivadoHover.png");
			} else {
				pastoPrivado.loadImage(img + "pastoPrivado.png");
			}

			if (mouse.isOverObject(pastoColetivo)) {
				pastoColetivo.loadImage(img + "pastoColetivoHover.png");
			} else {
				pastoColetivo.loadImage(img + "pastoColetivo.png");
			}

			window.update();
		}
	}

	private void draw() {
		background.draw();
		title.draw();
		pastoIndividual.draw();
		pastoPrivado.draw();
		pastoColetivo.draw();
	}
}
