package org.etotheipi.narwhal.domain.tower;

import org.etotheipi.narwhal.domain.Tower;

public class LoveTower extends Tower {

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

	protected int[][] getStats() {
		return new int[][] {
				{50, 75, 100, 125, 200}, // Power
				{1,  1,  2,   2,   5},   // Range
				{5,  5,  5,   6,   10},  // Rate of Fire
				{10, 10, 10,  10,  100}  // Cost
		};
	}

}