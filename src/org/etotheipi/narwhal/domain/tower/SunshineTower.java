package org.etotheipi.narwhal.domain.tower;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Tower;

public class SunshineTower extends Tower {

	

	protected int[][] getStats() {
		return new int[][] {
				{20, 40, 80,  160, 500}, // Power
				{1,  1,  1,   1,   1},   // Range
				{0,  0,  0,   0,   0},   // Rate of Fire
				{50, 80, 110, 140, 300}  // Cost
		};
	}

	@Override
	public void attack(Board b) {
		// TODO Auto-generated method stub
		
	}

}
