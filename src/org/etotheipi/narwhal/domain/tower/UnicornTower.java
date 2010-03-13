package org.etotheipi.narwhal.domain.tower;

import org.etotheipi.narwhal.domain.Tower;

public class UnicornTower extends Tower {

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

	protected int[][] getStats() {
		return new int[][] {
				{75, 100, 125, 150, 250}, // Power
				{2,  3,   4,   5,   10},  // Range
				{1,  2,   2,   3,   3},   // Rate of Fire
				{20, 30,  40,  50,  100}  // Cost
		};
	}

}
