package br.com.bracode.entity;

import jplay.Time;

public class Round {

	Time timer;
	int numero;

	int hour;
	int minute;
	int seconds;

	public Round(int hour, int minute, int second) {

		this.hour = hour;
		this.minute = minute;
		this.seconds = second;

		timer = new Time(hour, minute, second, 0, 0, false);
		
		numero = 1;
	}

	public void calculateRound() {

		if (timer.timeEnded()) {
			numero++;
			timer.setTime(hour, minute, seconds);
		}
	}

	public Time getTimer() {
		return timer;
	}

	public void setTimer(Time time) {
		this.timer = time;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		String string = "Rodada 0" + getNumero();

		if (getNumero() > 9) {
			string = "Rodada " + getNumero();
		}

		return string;
	}

}
