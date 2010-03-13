package org.etotheipi.narwhal.domain;

import java.awt.Point;

/**
 * Basic Absract Class for the creeps.
 */
public abstract class Creep {
	//Constants
	protected int level;
	protected Point location;
	protected int maxHealth;
	protected int currentHealth;
	protected int speed;

	public Creep(int level) {
		this.level = level;
		this.adjustByLevel();
	}

	public Creep() {
		this(1);
	}

	//Getters and Setters
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	public int getLevel() {
		return level;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public int getSpeed() {
		return speed;
	}
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * This will set up the Max Health and the speed
	 * based on the level specific for each creep.
	 */
	protected abstract void adjustByLevel();

}
