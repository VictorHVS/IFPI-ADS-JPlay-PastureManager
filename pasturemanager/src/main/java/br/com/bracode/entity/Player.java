package br.com.bracode.entity;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jplay.GameImage;
import br.com.bracode.tools.Settings;

public class Player {

	private String name;
	private String nick;
	private List<Sheep> sheeps;
	private int score;
	public	GameImage avatar;

	public Player() {
		String string;
		
		sheeps = new ArrayList<Sheep>();
		score = 0;

		for (int i = 0; i < 5; i++) {
			sheeps.add(new Sheep(Settings.img + "ovelha.png"));
		}

		string = JOptionPane.showInputDialog(null, "Digite seu nome completo:",
				"Credenciamento - Nome", JOptionPane.QUESTION_MESSAGE);
		setName(string);
		generateNick();

		string = JOptionPane.showInputDialog(null,
				"1 - Darth Vader\n2 - Stormtrooper\n3 - Princesa Leia",
				"Credenciamento - Avatar", JOptionPane.QUESTION_MESSAGE);
		if(Integer.parseInt(string) > 3 || Integer.parseInt(string) < 1){
			string = "2";
		}else{
			avatar = new GameImage(Settings.img + "avatar0" + string + ".png");
		}
		
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
	
	public String getScoreString(){
		if(score < 10){
			return "0000"+score;
		}else if(score < 100){
			return "000"+score;
		}else if(score < 1000){
			return "00"+score;
		}else if(score < 10000){
			return "0"+score;
		}else{
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
		}else{
			nick = name;
		}
	}
}
