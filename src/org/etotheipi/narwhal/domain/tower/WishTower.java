package org.etotheipi.narwhal.domain.tower;

import org.etotheipi.narwhal.domain.Tower;

public class WishTower extends Tower {

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

	protected int[][] getStats() {
		return new int[][] {
				{100, 150, 200, 250, 400}, // Power
				{2,   2,   3,   4,   6},   // Range
				{5,   5,   5,   6,   10},  // Rate of Fire
				{20,  30,  40,  50,  100}  // Cost
		};
	}
}