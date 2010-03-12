package org.etotheipi.narwhal.domain;

import java.awt.Point;

/**
 * Abstract class for all the towers.
 */
public abstract class Tower {
	//Constants
	private int rate;
	private int power;
	private Point location;
	private int range;
	private Bullet bullet;
	
	
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
	
	public abstract void attack();
	
}
