package org.etotheipi.narwhal.domain.tower;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

import org.etotheipi.narwhal.Constants;
import org.etotheipi.narwhal.NarwhalMain;
import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Bullet;
import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.Tower;

public class SunshineTower extends Tower {

	private final int SUN_OFF_INTERVAL = 10;
	private final int SUN_ON_INTERVAL  = 20;

	private int fireTime = 0;

	protected int[][] getStats() {
		return new int[][] {
				{20, 40, 80,  160, 500}, // Power
				{1,  1,  1,   1,   1},   // Range
				{0,  0,  0,   0,   0},   // Rate of Fire
				{20, 80, 110, 140, 300}  // Cost
		};
	}

	@Override
	public void attack(Board b) {
		fireTime = (fireTime + 1) % (SUN_OFF_INTERVAL + SUN_ON_INTERVAL);
		if (fireTime < SUN_OFF_INTERVAL) {
			this.bullets.clear();
		} else {
			if (this.bullets.isEmpty()) {
				this.bullets.add(new Sunlight(null, new Point(this.location.x - 3*Constants.SQUARE_SIZE/2,this.location.y - 3*Constants.SQUARE_SIZE/2)));
			}
			for (Creep creep : b.getCreepsNear(b.getSquareFor(location), 1)) {
				creep.dealDamage(50);
				if (creep.getCurrentHealth() <= 0) {
					b.getThePlayer().addMoney(creep.getValue());
					b.getCreepsOnBoard().remove(creep);
				}
			}
		}
	}

	private class Sunlight extends Bullet {

		public Sunlight(Creep target, Point location) {
			super(target, location);
			URL daURL = NarwhalMain.class.getResource("art/SunShield.png");
			bulletPic = new ImageIcon(daURL);
		}

		public boolean updateBullet() { return false; }

	}

}
