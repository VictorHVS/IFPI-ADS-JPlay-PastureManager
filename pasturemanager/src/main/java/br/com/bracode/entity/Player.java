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
	public GameImage molde;

	public Player(String name, int positionX, int positionY) {

		molde 		= new GameImage(Settings.img + "molde.png");
		molde.x 	= positionX;
		molde.y 	= positionY;

		sheeps = new ArrayList<Sheep>();
		score = 0;

		for (int i = 0; i < 5; i++) {
			sheeps.add(new Sheep(Settings.img + "ovelha.png"));
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

	}

}
