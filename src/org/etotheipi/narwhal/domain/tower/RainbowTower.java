package org.etotheipi.narwhal.domain.tower;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Tower;

public class RainbowTower extends Tower {

	

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
		// TODO Auto-generated method stub
		
	}

}
