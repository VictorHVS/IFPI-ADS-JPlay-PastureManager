package br.com.bracode.tools;

import java.awt.Font;

import jplay.Keyboard;
import jplay.Mouse;
import jplay.Window;

public class Settings {
	
	public static Window 	window;
	public static Mouse		mouse;
	public static Font		title;
	public static Font		subtitle;
	public static Font		userInfo;
	public static Font		titleConsole;
	public static Font		console;
	public static Font		bigText;
	public static Keyboard	keyboard;
	
	public static String img;
	public static int initialSheeps;
	public static int timeRodada;
	
	public Settings() {
		window 		= new Window(1366, 768);
		mouse		= window.getMouse();
		keyboard	= window.getKeyboard();
		img 		= "media/img/";
		title		= new Font("Century", Font.BOLD, 33);
		subtitle	= new Font("Century", Font.PLAIN, 25);
		userInfo	= new Font("Segoe UI", Font.BOLD, 17);
		console		= new Font("Courier New", Font.TYPE1_FONT, 14);
		bigText		= new Font("Courier New", Font.TYPE1_FONT, 36);
		titleConsole= new Font("Courier New", Font.TYPE1_FONT, 17);
		
		initialSheeps 	= 5;
		timeRodada		= 20;
	}
	
}
