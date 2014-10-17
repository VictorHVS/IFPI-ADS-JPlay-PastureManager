package br.com.bracode.pasturemanager;

import jplay.GameImage;
import jplay.Mouse;
import jplay.Window;

public class Credits {

	//private Window 		window;
	private Mouse		mouse;

	private GameImage 	background;
	private GameImage 	title;

	private	GameImage	credits;
	private GameImage	previous;
	
	private GameImage close;

	private String img;

	public Credits() {
		init();
		loop();
	}

	private void init() {
		img 		= "media/img/";
		//Menu.window 		= new Window(1366, 768);
		mouse 		= Menu.window.getMouse();
		background 	= new GameImage(img + "bg_green.png");

		title = new GameImage(img + "title.png");
		title.x = background.width / 2 - title.width / 2;
		title.y = 39;

		credits = new GameImage(img + "credits.png");
		credits.x = background.width / 2 - credits.width / 2;
		credits.y = 22;

		close = new GameImage(img + "close.png");
		close.x = background.width - close.width;
		close.y = 0;
		
		previous	= new GameImage(img + "voltar.png");
		previous.x 	= background.width / 2 - credits.width / 2 - previous.width;
		previous.y 	= 341;
	}

	private void loop() {
		while (true) {
			draw();	
			
			checkClick();
			Menu.window.update();
		}
	}

	private void draw() {
		background.draw();
		credits.draw();
		title.draw();
		close.draw();
		previous.draw();
	}

	private void checkClick() {

		if (mouse.isOverObject(close) && mouse.isLeftButtonPressed()) {
			Menu.window.exit();
		}
		
		if (mouse.isOverObject(previous) && mouse.isLeftButtonPressed()) {
			new Menu();
		}
		
		if (mouse.isOverObject(background) && mouse.isLeftButtonPressed()) {
			System.out.println("bg");
		}
	}


}
