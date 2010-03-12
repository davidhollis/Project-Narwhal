package org.etotheipi.narwhal.domain.creep;

import org.etotheipi.narwhal.domain.Creep;

public class Lust extends Creep {
	// Lust -- Fast Creep -- 50 hp/level, 25 speed + 5 speed/level
	protected void adjustByLevel() {
		this.maxHealth     = 50 * this.level;
		this.currentHealth = this.maxHealth;

		this.speed = 25 + 5 * this.level;
	}
}
