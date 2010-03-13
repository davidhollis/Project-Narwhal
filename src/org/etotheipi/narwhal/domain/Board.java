package org.etotheipi.narwhal.domain;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.etotheipi.narwhal.Constants;

public class Board {
	private Tower[][] spaces = new Tower[15][10];
	private List<Creep> creepsOnBoard;
	private Queue<Creep> creepsPending;
	private List<Point> bestPath;

	public Board(Queue<Creep> pending) {
		this.creepsPending = pending;
		this.creepsOnBoard = new ArrayList<Creep>();
		this.bestPath = new ArrayList<Point>();
	}

	public void update() {
		// Move the creeps
		for (Creep creep : creepsOnBoard) {
			creep.moveAlong(bestPath);
		}

		// Fire weapons
		for (Tower[] lst : spaces) {
			for (Tower tower : lst) {
				tower.attack(this);
			}
		}

		// Spawn new creep
		if (this.getCreepsAt(new Point(0,0)).isEmpty()) {
			if (!creepsPending.isEmpty()) {
				Creep newCreep = creepsPending.remove();
				newCreep.setLocation(this.getCenterOf(new Point(0,0)));
				creepsOnBoard.add(newCreep);
			}
		}
	}

	public Tower getTowerAt(Point location) {
		if ((location.x >= spaces.length) || (location.y >= spaces[0].length)) {
			throw new IllegalArgumentException("specified point " + location + " out of range.");
		}
		return spaces[location.x][location.y];
	}

	public List<Creep> getCreepsAt(Point location) {
		ArrayList<Creep> creeps = new ArrayList<Creep>();
		Rectangle bounds = this.getBoundsOf(location);
		for (Creep creep : creepsOnBoard) {
			if (bounds.contains(creep.getLocation())) {
				creeps.add(creep);
			}
		}
		return new ArrayList<Creep>();
	}

	public List<Creep> getCreepsNear(Point location, int radius) {
		radius *= Constants.SQUARE_SIZE;
		int rr = radius * radius;
		Point center = this.getCenterOf(location);

		ArrayList<Creep> creeps = new ArrayList<Creep>();

		for (Creep creep : creepsOnBoard) {
			int dx = center.x - creep.getLocation().x,
			    dy = center.y - creep.getLocation().y;
			if (dx*dx + dy*dy < rr) {
				creeps.add(creep);
			}
		}

		return creeps;
	}

	protected Rectangle getBoundsOf(Point location) {
		return new Rectangle(
				location.x * Constants.SQUARE_SIZE,
				location.y * Constants.SQUARE_SIZE,
				Constants.SQUARE_SIZE,
				Constants.SQUARE_SIZE);
	}

	protected Point getCenterOf(Point location) {
		return new Point(
				location.x * Constants.SQUARE_SIZE + (Constants.SQUARE_SIZE / 2),
				location.y * Constants.SQUARE_SIZE + (Constants.SQUARE_SIZE / 2));
	}

	// TODO write pathfinding
	// TODO check whether a tower can be placed
}
