package br.com.bracode.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import jplay.GameImage;
import br.com.bracode.entity.Player;
import br.com.bracode.tools.Message;
import br.com.bracode.tools.Settings;


public class Environment {

	private static GameImage background;

	private static GameImage topbar;
	private static GameImage ground;
	
	private static GameImage console;
	private static GameImage statistics;
	private static GameImage action;

	private static GameImage close;
	private static GameImage home;
	
	private static GameImage corral;
	private static GameImage boardGrass;
	
	private static List<Grass> 	grasses;
	private static List<Player>	players;
	
	public Environment() {
		background = new GameImage(Settings.img + "bg_green.png");
		
		grasses = new ArrayList<Grass>();
		players = new ArrayList<Player>();
		
		int linha = 1;
		int coluna = 1;
		
		for (int i = 0; i < 100; i++) {
			
			grasses.add(new Grass("resources/imagens/bloco.png"));
			
			grasses.get(i).x = coluna * 70;
			grasses.get(i).y = 70 + (linha * 40);
			
			coluna++;
			
			if(coluna % 11 == 0){
				coluna = 1;
				linha++;
			}
		}

		close 	= new GameImage(Settings.img + "close.png");
		close.x = background.width - close.width;
		close.y = 0;

		home 	= new GameImage(Settings.img + "home.png");
		home.x 	= background.width - home.width;
		home.y 	= close.height;

		topbar	 = new GameImage(Settings.img + "topbar.png");
		topbar.x = 0;
		topbar.y = 0;

		ground	 = new GameImage(Settings.img + "ground.png");
		ground.x = 0;
		ground.y = topbar.height;
		
		console 	= new GameImage(Settings.img + "console.png");
		console.x 	= 284;
		console.y 	= 572;
		
		statistics 		= new GameImage(Settings.img + "statistics.png");
		statistics.x	= 405;
		statistics.y 	= 20;
		
		action	 = new GameImage(Settings.img + "action.png");
		action.x = 270;
		action.y = 20;
		
		corral	 = new GameImage(Settings.img + "corral.png");
		corral.x = 63;
		corral.y = 172;
		
		boardGrass	 = new GameImage(Settings.img + "boardGrass.png");
		boardGrass.x = 284;
		boardGrass.y = 163;
	}
	
	public static void draw() {
		background.draw();
		topbar.draw();
		ground.draw();
		home.draw();
		close.draw();
		console.draw();
		statistics.draw();
		action.draw();
		corral.draw();
		boardGrass.draw();
		drawPlayers();
		
		for(Grass grass : grasses){
			grass.draw();
		}
	}

	public static void checkclick(){
		if (Settings.mouse.isOverObject(close) && Settings.mouse.isLeftButtonPressed()) {
			Message.exit();
		}else if (Settings.mouse.isOverObject(home) && Settings.mouse.isLeftButtonPressed()) {
			Message.home();
		} else if (Settings.mouse.isOverObject(background) && Settings.mouse.isLeftButtonPressed()) {
			System.out.println("bg");
		}
	}
	
	public static void addPlayer(Player p){
		players.add(p);
	}
	
	public static void drawPlayers(){
		for (Player player : players){
			Settings.window.drawText(player.getNick(), 63, 168, Color.WHITE, Settings.console);
			Settings.window.drawText(player.getQuantSheepString(), 186, 168, Color.WHITE, Settings.console);
		}
	}
	
	public static void resetPlayers(){
		players = new ArrayList<Player>();
	}
}
