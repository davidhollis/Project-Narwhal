package org.etotheipi.narwhal.domain.tower;

import java.awt.Point;
import java.util.List;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.Tower;
import org.etotheipi.narwhal.domain.projectile.Rainbow;

public class RainbowTower extends Tower {
	protected int fireTime = 0;


	protected int[][] getStats() {
		return new int[][] {
				{10, 15, 20, 25, 100}, // Power
				{0,  0,  0,  0,  0},   // Range
				{0,  0,  0,  0,  0},   // Rate of Fire
				{30, 40, 50, 60, 150}  // Cost
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
				Rainbow h = new Rainbow(target,(Point)this.location.clone());
				this.bullets.add(h);
			}
		}
	}

}
