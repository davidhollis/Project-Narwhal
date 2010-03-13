package org.etotheipi.narwhal.domain;

/**
 * @author Bobby
 *
 */
public class Player {
	//constants
	private int money;
	private int waveNumber;
	private int score;
	private int health;
	
	//getters and setters
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getWaveNumber() {
		return waveNumber;
	}
	public void setWaveNumber(int waveNumber) {
		this.waveNumber = waveNumber;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	//methods
}
