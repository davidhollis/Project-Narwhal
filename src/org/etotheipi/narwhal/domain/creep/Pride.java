package org.etotheipi.narwhal.domain.creep;

import org.etotheipi.narwhal.domain.Creep;

public class Pride extends Creep {
	// Pride -- Flying Creep -- 100 hp + 75 hp/level, 20 speed
	protected void adjustByLevel() {
		this.maxHealth = 100 + 75 * this.level;
		this.currentHealth = this.maxHealth;

		this.speed = 20;
	}

}
