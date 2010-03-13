package org.etotheipi.narwhal.domain.creep;

import org.etotheipi.narwhal.domain.Creep;

public class Sloth extends Creep {
	// Sloth -- Slow Creep -- 200 hp/level, 15 speed
	protected void adjustByLevel() {
		this.maxHealth = 200 * this.level;
		this.currentHealth = this.maxHealth;

		this.speed = 1;
	}
}
