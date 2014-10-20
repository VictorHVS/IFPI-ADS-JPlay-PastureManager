package br.com.bracode.tools;

import java.awt.Font;

import jplay.Mouse;
import jplay.Window;

public class Settings {
	
	public static Window 	window;
	public static Mouse		mouse;
	public static Font		title;
	public static Font		subtitle;
	public static Font		userInfo;
	
	public static String img;
	
	public Settings() {
		window 		= new Window(1366, 768);
		mouse		= window.getMouse();
		img 		= "media/img/";
		title		= new Font("Century", Font.BOLD, 33);
		subtitle	= new Font("Century", Font.BOLD, 17);
		userInfo	= new Font("Segoe UI", Font.BOLD, 17);
	}
}
