package org.etotheipi.narwhal.domain;

import java.awt.Point;
import java.awt.Rectangle;

import org.etotheipi.narwhal.Constants;

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
	protected int value;

	protected Direction movementDirection = Direction.NORTH;

	public Creep(int level) {
		this.level = level;
		this.adjustByLevel();
		value = level * 10;
	}

	public Creep() {
		this(1);
	}

	//Getters and Setters
	public void dealDamage(int damage)
	{
		currentHealth = Math.max(currentHealth - damage, 0);
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int newLevel) {
		this.level = newLevel;
		this.adjustByLevel();
		value = level * 10;
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

	public void move(Board board) {
		Point space = board.getSquareFor(location);
		Rectangle bounds = board.getBoundsOf(space);

		if (bounds.contains(new Rectangle(
				location.x - Constants.CREEP_SIZE/2,
				location.y - Constants.CREEP_SIZE/2,
				Constants.CREEP_SIZE,
				Constants.CREEP_SIZE))) {
			// Creep is entirely inside the current box
			this.movementDirection = board.getPolicy()[space.x][space.y];
		}

		switch (this.movementDirection) {
			case NORTH:
				this.location.y = Math.max(Constants.CREEP_SIZE/2, this.location.y - this.speed);
				break;
			case SOUTH:
				this.location.y = Math.min(10*Constants.SQUARE_SIZE - Constants.CREEP_SIZE/2, this.location.y + this.speed);
				break;
			case WEST:
				this.location.x = Math.max(Constants.CREEP_SIZE/2, this.location.x - this.speed);
				break;
			case EAST:
				this.location.x = Math.min(15*Constants.SQUARE_SIZE - Constants.CREEP_SIZE/2, this.location.x + this.speed);
				break;
		}
	}

	public int getValue() {
		return value;
	}



}
