package br.com.bracode.entity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jplay.GameImage;
import br.com.bracode.tools.Settings;
import br.com.bracode.tools.Utils;

public class Player {

	private String name;
	private String nick;
	private List<Sheep> sheeps;
	private int score;
	public GameImage avatar;
	//Gambiarra Mutchu Loca
	public GameImage molde;

	public Player(String name, int positionX, int positionY) {

		molde 		= new GameImage(Settings.img + "molde.png");
		molde.x 	= positionX;
		molde.y 	= positionY;

		sheeps = new ArrayList<Sheep>();
		score = 0;
		for (int i = 0; i < Settings.initialSheeps; i++) {
			addSheep(63, 172);
		}
		
		setName(name);

		generateNick();
		avatarRandom();

	}

	private void avatarRandom() {
		Random r = new Random();
		avatar = new GameImage("media/img/avatar/0" + r.nextInt(6) + ".png");
		avatar.x = molde.x + molde.width / 2 - avatar.width / 2;
		avatar.y = molde.y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sheep> getSheeps() {
		return sheeps;
	}

	public void setSheeps(List<Sheep> sheeps) {
		this.sheeps = sheeps;
	}

	public int getScore() {
		return score;
	}

	public String getScoreString() {
		if (score < 10) {
			return "0000" + score;
		} else if (score < 100) {
			return "000" + score;
		} else if (score < 1000) {
			return "00" + score;
		} else if (score < 10000) {
			return "0" + score;
		} else {
			return Integer.toString(score);
		}
	}
	
	public String getQuantSheepString() {
		if (sheeps.size() < 10) {
			return "x0" + sheeps.size();
		} else {
			return "x" + sheeps.size();
		}
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addScore(int pontuation) {
		this.score += pontuation;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void generateNick() {
		if (name.contains(" ")) {
			nick = String.valueOf(name.toCharArray(), 0, name.indexOf(" "));
		} else {
			nick = name;
		}
	}

	public void draw() {
		avatar.draw();
		
		int xName 	= (int) (molde.x + molde.width / 2 - Utils.getWidthText(getNick(), Settings.userInfo) / 2);
		int xScore 	= (int) (molde.x + molde.width / 2 - Utils.getWidthText(getScoreString(), Settings.userInfo) / 2);
		
		Settings.window.drawText(getNick(), xName, 91, Color.white,	Settings.userInfo);
		Settings.window.drawText(getScoreString(), xScore, 112, Color.white, Settings.userInfo);
		
		for (Sheep sheep : sheeps) {
			sheep.draw();
		}

	}
	
	public void addSheep(int referenciaX, int referenciaY){
		Sheep shep 			= new Sheep(Settings.img + "sheep.png");
		shep.x				= referenciaX + 15;
		shep.y				= referenciaY + 31;
		int tamanho			= sheeps.size();
		boolean	isDiferent 	= false;
		
		if(sheeps.isEmpty()){
			sheeps.add(shep);
		}else{
			int i = 0;
			while(true){
				
				if(shep.x == sheeps.get(i).x && shep.y == sheeps.get(i).y){
					isDiferent = false;
					shep.x += shep.width + 9;
					if (shep.x > referenciaX + 140) {
						shep.x = referenciaX + 16;
						shep.y += shep.height + 15;
					}
					i = 0;
				}
				++i;
				if(tamanho == i){
					isDiferent = true;
				}
				
				if(isDiferent){
					sheeps.add(shep);
					break;
				}
			
			}
		}
	}

}
