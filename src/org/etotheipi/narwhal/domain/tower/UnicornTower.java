package org.etotheipi.narwhal.domain.tower;

import java.awt.Point;
import java.util.List;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.Tower;
import org.etotheipi.narwhal.domain.projectile.Unicorn;

public class UnicornTower extends Tower {
	protected int fireTime = 0;


	protected int[][] getStats() {
		return new int[][] {
				{75, 100, 125, 150, 250}, // Power
				{2,  3,   4,   5,   10},  // Range
				{1,  2,   2,   3,   3},   // Rate of Fire
				{20, 30,  40,  50,  100}  // Cost
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
				Unicorn h = new Unicorn(target,(Point)this.location.clone());
				this.bullets.add(h);
			}
		}
	}

}
