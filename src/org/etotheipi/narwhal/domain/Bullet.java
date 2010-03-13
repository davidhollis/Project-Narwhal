package org.etotheipi.narwhal.domain;

import java.awt.Point;
import java.util.Vector;
import javax.swing.ImageIcon;

/**
 * TODO: No idea how to set this up.
 *
 */
public abstract class Bullet {

	private final int targetLeeway = 5;
	private Creep target;
	private Point location;
	private int speed;
	protected ImageIcon bulletPic;
	
	public Bullet(Creep target, Point location)
	{
		this.target = target;
		this.location = location;
	}
	
	/**
	 * Updates the position of the bullet
	 * returns true if the bullet hits.
	 * Bullet hits if it's within targetLeeway.
	 * @return true if bullet hits.
	 */
	
	public boolean updateBullet()
	{
		Point foeLoc = target.getLocation();
		Point direction = new Point(foeLoc.x - location.x, foeLoc.y - location.y);
		/*Normalize direction vector*/
		double magnitude = Math.sqrt(direction.x*direction.x + direction.y*direction.y);
		double xDirection = direction.x / magnitude;
		double yDirection = direction.y / magnitude;
		/* Multiply by speed*/
		xDirection *= speed;
		yDirection *= speed;
		
		location.x = Math.round((float)xDirection) + location.x;
		location.y = Math.round((float)yDirection) + location.y;
		
		boolean hit = Math.abs(location.x - foeLoc.x) <= targetLeeway;
		hit = hit && Math.abs(location.y - foeLoc.y) <= targetLeeway;
		
		return hit;
	}
	
	public ImageIcon getIcon()
	{
		return bulletPic;
	}

}
