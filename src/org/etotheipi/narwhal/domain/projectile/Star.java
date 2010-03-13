package org.etotheipi.narwhal.domain.projectile;

import java.awt.Point;
import java.net.URL;

import javax.swing.ImageIcon;

import org.etotheipi.narwhal.NarwhalMain;
import org.etotheipi.narwhal.domain.Bullet;
import org.etotheipi.narwhal.domain.Creep;

public class Star extends Bullet {

	public Star(Creep target, Point location) {
		super(target, location);
		URL daURL = NarwhalMain.class.getResource("art/StarBullet.png");
		bulletPic = new ImageIcon(daURL);
	}

}
