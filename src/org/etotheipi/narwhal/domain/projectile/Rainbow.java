package org.etotheipi.narwhal.domain.projectile;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

import org.etotheipi.narwhal.NarwhalMain;
import org.etotheipi.narwhal.domain.Bullet;
import org.etotheipi.narwhal.domain.Creep;

public class Rainbow extends Bullet {
	public Rainbow(Creep target, Point location) {
		super(target, location);
		URL heart_URL = NarwhalMain.class.getResource("art/RainbowBullet.png");
		bulletPic = new ImageIcon(heart_URL);
	}
}
