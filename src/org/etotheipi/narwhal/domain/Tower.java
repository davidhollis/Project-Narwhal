package org.etotheipi.narwhal.domain;

import java.awt.Point;

import org.etotheipi.narwhal.Constants;

/**
 * Abstract class for all the towers.
 */
public abstract class Tower {
	//Constants
	protected int rate;
	protected int power;
	protected Point location;
	protected int range;
	protected int level;

	public Tower(Point location) {
		this.level = 1;
		this.rate = this.getRate(this.level);
		this.power = this.getPower(this.level);
		this.range = this.getRange(this.level);
		this.location = location;
	}

	public Tower() {
		this(new Point(0,1));
	}

	//Getters and Setters.
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}

	public int getPower(int level) {
		return this.getStats()[0][level-1];
	}

	public int getRange(int level) {
		return this.getStats()[1][level-1];
	}

	public int getRate(int level) {
		return this.getStats()[2][level-1];
	}

	public int getCost() {
		int[] prices = getStats()[3];
		int cost = 0;

		for (int i = 0; i < this.level; ++i) {
			cost += prices[i];
		}

		return cost;
	}

	public int getUpgradeCost() {
		if (this.level < Constants.MAX_TOWER_LEVEL) {
			return this.getStats()[3][this.level];
		} else {
			return -1;
		}
	}

	public int getSellPrice() {
		return getCost()/2;
	}

	/**
	 * Gets the statistics for this tower.
	 * @return A two-dimensional array of the form { {lv1_power, lv2_power, ... , lv5_power}, {lv1_range, ... , lv5_range}, {lv1_rate, ... , lv5_rate}, {lv1_cost, ... , lv5_cost} }
	 */
	protected abstract int[][] getStats();

	/**
	 * This method actually does the attack.
	 */
	public abstract void attack();
}
