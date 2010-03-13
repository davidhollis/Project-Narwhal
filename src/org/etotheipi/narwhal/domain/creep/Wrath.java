package org.etotheipi.narwhal.domain.creep;

import org.etotheipi.narwhal.domain.Creep;

public class Wrath extends Creep {
	// Wrath -- Normal Creep -- 100 hp/level, 20 speed
	protected void adjustByLevel() {
		this.maxHealth     = 100*this.level;
		this.currentHealth = this.maxHealth;

		this.speed = 1;
	}
}
