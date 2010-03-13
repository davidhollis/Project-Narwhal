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
	/**
	 * Returns true if there's enough monies.
	 * @param moneyToSpend
	 * @return true if there's enough monies
	 */
	public boolean spendMoney(int moneyToSpend)
	{
		if(money - moneyToSpend >= 0)
		{
			money -= moneyToSpend;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void addMoney(int moMoney)
	{
		money += moMoney;
	}
	
	//True if you're dead
	public boolean hurt()
	{
		health--;
		return health <= 0;
	}
	
	//methods
}
