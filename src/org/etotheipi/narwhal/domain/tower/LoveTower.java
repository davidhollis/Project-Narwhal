package org.etotheipi.narwhal.domain.tower;

import java.awt.Point;
import java.util.List;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.Tower;
import org.etotheipi.narwhal.domain.projectile.Heart;

public class LoveTower extends Tower {
	protected int fireTime = 0;



	protected int[][] getStats() {
		return new int[][] {
				{50, 75, 100, 125, 200}, // Power
				{1,  1,  2,   2,   5},   // Range
				{5,  5,  5,   6,   10},  // Rate of Fire
				{10, 10, 10,  10,  100}  // Cost
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
				Heart h = new Heart(target,(Point)this.location.clone());
				this.bullets.add(h);
			}
		}
	}

}
