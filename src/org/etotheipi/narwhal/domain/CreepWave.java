package org.etotheipi.narwhal.domain;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Bobby
 *
 */
public class CreepWave {
	//constants
	private Queue<Creep> creeps;
	
	/**
	 * Basic Constructor that initializes creeps
	 */
	public CreepWave() {
		creeps = new ArrayDeque<Creep>();		
	}

	/**
	 * Basic getter for the Queue
	 * @return the creeps 
	 */
	public Queue<Creep> getCreeps() {
		return creeps;
	}
	
	/**
	 * Adds a creep to the CreepWave
	 * @param creep The Creep to Add
	 */
	public void addCreep(final Creep creep) {
		creeps.add(creep);
	}
	
	/**
	 * This will get the next creep to be launched.
	 * It will then remove it from the queue.
	 * @return The next creep to be launched
	 */
	public Creep dequeueCreep() {
		return creeps.remove();
	}
	
}
