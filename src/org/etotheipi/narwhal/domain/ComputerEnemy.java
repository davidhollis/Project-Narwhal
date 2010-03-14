package org.etotheipi.narwhal.domain;

import org.etotheipi.narwhal.domain.creep.Wrath;

public class ComputerEnemy {
	//constants
	
	//Getters and Setters
	
	//Methods
	
	/**
	 * Figures out what the next wave is going to be.
	 * @return The wave about to be sent out.
	 */
	public CreepWave getNextWave() {
		//TODO something that doesn't return 10 normal creeps
		CreepWave retWave = new CreepWave();
		for(int i=0; i<10; i++) {
			retWave.addCreep(new Wrath());
		}
		return retWave;
	}
	
	
}
