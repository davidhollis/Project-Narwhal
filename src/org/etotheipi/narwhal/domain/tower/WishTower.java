package org.etotheipi.narwhal.domain.tower;

import java.awt.Point;
import java.util.List;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.Tower;
import org.etotheipi.narwhal.domain.projectile.Star;

public class WishTower extends Tower {
	protected int fireTime = 0;

	protected int[][] getStats() {
		return new int[][] {
				{100, 150, 200, 250, 400}, // Power
				{2,   2,   3,   4,   6},   // Range
				{5,   5,   5,   6,   10},  // Rate of Fire
				{20,  30,  40,  50,  100}  // Cost
		};
	}

	@Override
	public void attack(Board b) {
		fireTime = (fireTime + 1) % 20;
		if (fireTime == 0) {
			List<Creep> targets = b.getCreepsNear(b.getSquareFor(this.location), this.range);
			Creep target = null;
			if (!targets.isEmpty()) {
				target = targets.get(0);
				Star h = new Star(target,(Point)this.location.clone());
				this.bullets.add(h);
			}
		}
	}
}
