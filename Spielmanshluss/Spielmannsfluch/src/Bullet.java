import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Bullet extends Thread {
	private JComponent weapon;
	private JPanel area;

	public Bullet(JComponent weapon, JPanel area) {
		this.weapon = weapon;
		this.area = area;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (;;) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Rectangle oldBounds = weapon.getBounds();
			oldBounds.x += 10;
			weapon.setBounds(oldBounds);
			if (weapon.getBounds().x >= area.getBounds().width) {
				area.remove(weapon);
				break;
			}
		}
	}

}
